/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package joshua.decoder.io;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import joshua.decoder.JoshuaConfiguration;
import joshua.decoder.Translation;
import joshua.decoder.TranslationFactory;
import joshua.decoder.hypergraph.DerivationState;
import joshua.decoder.hypergraph.KBestExtractor;
import joshua.decoder.segment_file.Sentence;

public class JSONMessage {
  public Data data = null;
  public List<String> rules = null;
  
  public JSONMessage() {
  }
  
  public class Data {
    public List<TranslationItem> translations;
    
    public Data() {
      translations = new ArrayList<TranslationItem>();
    }
  }
  
  public TranslationItem addTranslation(String text) {
    if (data == null)
      data = new Data();
    
    TranslationItem newItem = new TranslationItem(text);
    data.translations.add(newItem);
    return newItem;
  }
  
  public class TranslationItem {
    public String translatedText;
    public List<NBestItem> raw_nbest;
    
    public TranslationItem(String value) {
      this.translatedText = value;
      this.raw_nbest = new ArrayList<NBestItem>();
    }
    
    public void addHypothesis(String hyp, float score) {
      this.raw_nbest.add(new NBestItem(hyp, score));
    }
  }
  
  public class NBestItem {
    public String hyp;
    public float totalScore;
    
    public NBestItem(String hyp, float score) {
      this.hyp = hyp;
      this.totalScore = score;  
    }
  }
  
  public void addRule(String rule) {
    if (rules == null)
      rules = new ArrayList<String>();
    rules.add(rule);
  }

  public class MetaData {

    public MetaData() {
    }
  }

  public static JSONMessage buildMessage(Sentence sentence, KBestExtractor extractor, JoshuaConfiguration config) {
    JSONMessage message = new JSONMessage();
    
    final String mosesFormat = "%i ||| %s ||| %f ||| %c"; 
    
    int k = 1;
    for (DerivationState derivation: extractor) {
      if (k > config.topN)
        break;
      
      TranslationFactory factory = new TranslationFactory(sentence, derivation, config);
      Translation translation = factory.formattedTranslation(mosesFormat).translation();

      JSONMessage.TranslationItem item = message.addTranslation(translation.toString());
      item.addHypothesis(translation.toString(), translation.score());
      
      k++;
    }

    return message;
  }
  
  public String toString() {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    return gson.toJson(this);
  }
}