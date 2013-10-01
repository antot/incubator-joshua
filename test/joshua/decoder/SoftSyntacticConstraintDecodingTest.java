package joshua.decoder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.testng.Assert;

import joshua.decoder.FeatureFunctionsTest.DecoderOutput;
import joshua.decoder.ff.LabelSubstitutionFF;
import joshua.decoder.ff.StatefulFF;
import joshua.util.FileUtility;

public class SoftSyntacticConstraintDecodingTest {

  protected static String SOFT_SYNTACTIC_CONSTRAINT_DECODING_TEST_TEMP_FILES_FOLDER_NAME = "SoftSyntacticConstraintDecodingTestTempFiles";

  private static String LABEL_SUBSTITUTION_FEATURE_NAME = LabelSubstitutionFF
      .getLowerCasedFeatureName();
  protected static String MAIN_GRAMMAR_FILE_NAME = "mainGrammar.txt";
  protected static String GLUE_GRAMMAR_FILE_NAME = "glueGrammar.txt";
  private static String JOSHUA_CONFIG_FILE_NAME_BASIC = "joshua.basic.config";
  private static String JOSHUA_CONFIG_FILE_NAME_BASIC_EXTRA_FEATURES = "joshua.basic.extra-features.config";
  private static String JOSHUA_CONFIG_FILE_NAME_SOFT_SYNTACTIC = "joshua.soft-syntactic.config";
  private static String JOSHUA_CONFIG_FILE_NAME_SOFT_SYNTACTIC_EXTRA_FEATURES = "joshua.soft-syntactic.extra-features.config";
  private static final String TEST_FILE_NAME = "testSentences.txt";

  private static final List<Double> getPhraseTableWeights() {
    return Arrays.asList(0.5, 0.5);
  }

  public static TestConfigFileCreater createFeaturesTestConfigFileCreater(
      boolean useSoftSyntacticConstraintsDecoding) {
    return TestConfigFileCreater.createFeaturesTestConfigFileCreater(
        SOFT_SYNTACTIC_CONSTRAINT_DECODING_TEST_TEMP_FILES_FOLDER_NAME, MAIN_GRAMMAR_FILE_NAME,
        GLUE_GRAMMAR_FILE_NAME, getPhraseTableWeights(),useSoftSyntacticConstraintsDecoding,true);
  }

  private static final TestConfigFileCreater TEST_CONFIG_FILE_CREATER_SOFT_CONSTRAINTS = createFeaturesTestConfigFileCreater(true);
  private static final TestConfigFileCreater TEST_CONFIG_FILE_CREATER_NORMAL_DECODING = createFeaturesTestConfigFileCreater(false);

  private static void writeBasicJoshuaConfigFile(TestConfigFileCreater testConfigFileCreater,
      boolean useLabelSubstitutionFeatures, String configFileName) {
    if (useLabelSubstitutionFeatures) {
      testConfigFileCreater.writeBasicJoshuaConfigFile(configFileName,
          LABEL_SUBSTITUTION_FEATURE_NAME);
    } else {
      testConfigFileCreater.writeBasicJoshuaConfigFile(configFileName);
    }
  }

  private static void createTestFilesBasicTest(TestConfigFileCreater testConfigFileCreater,
      boolean useLabelSubstitutionFeatures, String configFileName) {
    FileUtility
        .createFolderIfNotExisting(SOFT_SYNTACTIC_CONSTRAINT_DECODING_TEST_TEMP_FILES_FOLDER_NAME);

    writeBasicJoshuaConfigFile(testConfigFileCreater, useLabelSubstitutionFeatures, configFileName);
    String mainGrammarFilePath = testConfigFileCreater.createFullPath(MAIN_GRAMMAR_FILE_NAME);
    String glueGrammarFilePath = testConfigFileCreater.createFullPath(GLUE_GRAMMAR_FILE_NAME);
    String testFilePath = testConfigFileCreater.createFullPath(TEST_FILE_NAME);

    ArtificialGrammarAndCorpusCreater artificialGrammarAndCorpusCreater = ArtificialGrammarAndCorpusCreater
        .createArtificialGrammarAndCorpusCreater(mainGrammarFilePath, glueGrammarFilePath,
            testFilePath);
    artificialGrammarAndCorpusCreater.writeMainGrammar();
    artificialGrammarAndCorpusCreater.writeTestSentencesFile1();
    artificialGrammarAndCorpusCreater.writeGlueGrammar();
    copyStaticFilesToTestDirectory(testConfigFileCreater);
  }

  private static void copyStaticFilesToTestDirectory(TestConfigFileCreater testConfigFileCreater) {
    FeatureFunctionsTest.copyOriginnlFileToTestDirectory(testConfigFileCreater,
        FeatureFunctionsTest.ORIGINAL_LANGUAGE_MODEL_FILE_PATH,
        TestConfigFileCreater.LANGUAGE_MODEL_FILE_NAME);
  }

  private DecoderOutput runSoftSyntacticConstraintDecoding(boolean useLabelSubstitutionFeatures,
      String configFileName) {
    createTestFilesBasicTest(TEST_CONFIG_FILE_CREATER_SOFT_CONSTRAINTS,
        useLabelSubstitutionFeatures, configFileName);
    String testInputFilePath = "./"
        + SOFT_SYNTACTIC_CONSTRAINT_DECODING_TEST_TEMP_FILES_FOLDER_NAME + "/" + TEST_FILE_NAME;
    String joshuaConfigFilePath = TEST_CONFIG_FILE_CREATER_SOFT_CONSTRAINTS
        .createFullPath(configFileName);
    DecoderOutput decoderOutput1 = FeatureFunctionsTest.runDecoder(joshuaConfigFilePath,
        testInputFilePath, LABEL_SUBSTITUTION_FEATURE_NAME);
    return decoderOutput1;
  }

  private void testSoftSyntacticConstraintDecodingHasexpectedNumberDerivations(
      int expectedNumberDerivations) {
    DecoderOutput decoderOutput1 = runSoftSyntacticConstraintDecoding(false,
        JOSHUA_CONFIG_FILE_NAME_SOFT_SYNTACTIC);
    // Test that the number of derivations in the list is 2
    int numberOfDerivationsInNBestList = decoderOutput1.getnBestListTotalWeights().size();
    Assert.assertEquals(numberOfDerivationsInNBestList, expectedNumberDerivations);

  }

  private void testNormalDecodingHasexpectedNumberDerivations(int expectedNumberDerivations) {
    DecoderOutput decoderOutput1 = runNormalDecoding(false, JOSHUA_CONFIG_FILE_NAME_BASIC);
    // Test that the number of derivations in the list is 2
    int numberOfDerivationsInNBestList = decoderOutput1.getnBestListTotalWeights().size();
    Assert.assertEquals(numberOfDerivationsInNBestList, expectedNumberDerivations);
  }

  private DecoderOutput runNormalDecoding(boolean useLabelSubstitutionFeatures,
      String configFileName) {
    createTestFilesBasicTest(TEST_CONFIG_FILE_CREATER_NORMAL_DECODING,
        useLabelSubstitutionFeatures, configFileName);
    String testInputFilePath = "./"
        + SOFT_SYNTACTIC_CONSTRAINT_DECODING_TEST_TEMP_FILES_FOLDER_NAME + "/" + TEST_FILE_NAME;
    String joshuaConfigFilePath = TEST_CONFIG_FILE_CREATER_SOFT_CONSTRAINTS
        .createFullPath(configFileName);
    DecoderOutput decoderOutput1 = FeatureFunctionsTest.runDecoder(joshuaConfigFilePath,
        testInputFilePath, LABEL_SUBSTITUTION_FEATURE_NAME);
    return decoderOutput1;
  }

  @Test
  /**
   * This test tests soft syntactic constraint decoding in the following way.
   * It decodes a test sentence for a grammar that yields multiple derivations 
   * if soft syntactic constraint decoding is done, but only one derivation if
   * only rigid matching of labels is permitted.
   * In particular, we expect in total 4 derivations, resulting from different 
   * combinations of alternative/original terminal rules with matching/non-matching labels.
   */
  // This test must be ran with the following VM arguments: -Djava.library.path=./lib
  // in order to properly link KenLM as needed by the decoder
  public void testSoftSyntacticConstraintDecoding() {
    StatefulFF.resetGlobalStateIndex();
    testSoftSyntacticConstraintDecodingHasexpectedNumberDerivations(9);
    // TODO : Please Refactor so this is no longer necessary
    StatefulFF.resetGlobalStateIndex();
    testNormalDecodingHasexpectedNumberDerivations(1);

  }

  private static <E> Set<E> getUniqueElementsList(Set<E> setTest, Set<E> setReference) {
    Set<E> result = new HashSet<E>(setTest);
    result.removeAll(setReference);
    return result;
  }

  @Test
  public void testSoftSyntacticDecodingYieldsDifferentSubstitutionFeatures() {
    StatefulFF.resetGlobalStateIndex();
    DecoderOutput decoderOutputNormalDecoding = runNormalDecoding(true,
        JOSHUA_CONFIG_FILE_NAME_BASIC_EXTRA_FEATURES);
    StatefulFF.resetGlobalStateIndex();
    DecoderOutput decoderOutputSoftConstraintDecoding = runSoftSyntacticConstraintDecoding(true,
        JOSHUA_CONFIG_FILE_NAME_SOFT_SYNTACTIC_EXTRA_FEATURES);

    Set<String> extraFeatureNamesNormalDecoding = new HashSet<String>(
        decoderOutputNormalDecoding.getExtraFeaturesList());
    Set<String> extraFeatureNamesSoftSyntacticDecoding = new HashSet<String>(
        decoderOutputSoftConstraintDecoding.getExtraFeaturesList());

    System.out.println(">>>normalDecoding extra features: <<<");
    for (String featureName : extraFeatureNamesNormalDecoding) {
      System.out.println(featureName);
    }

    System.out.println(">>> Soft syntactic Decoding extra features: <<<");
    for (String featureName : extraFeatureNamesSoftSyntacticDecoding) {
      System.out.println(featureName);
    }

    // Set<String> extraFeatureNamesUniqueForNormalDecoding =
    // getUniqueElementsList(extraFeatureNamesNormalDecoding,
    // extraFeatureNamesSoftSyntacticDecoding);
    Set<String> extraFeatureNamesUniqueForSoftSyntacticDecoding = getUniqueElementsList(
        extraFeatureNamesSoftSyntacticDecoding, extraFeatureNamesNormalDecoding);

    Assert.assertTrue(!extraFeatureNamesUniqueForSoftSyntacticDecoding.isEmpty());
    for (String featureName : extraFeatureNamesUniqueForSoftSyntacticDecoding) {
      System.out.println("feature unique for soft-syntactic decoding: " + featureName);
    }

  }

}
