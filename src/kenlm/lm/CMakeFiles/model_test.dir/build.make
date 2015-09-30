# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.3

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list


# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /opt/local/bin/cmake

# The command to remove a file.
RM = /opt/local/bin/cmake -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /Users/post/code/joshua/src/kenlm

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /Users/post/code/joshua/src/kenlm

# Include any dependencies generated for this target.
include lm/CMakeFiles/model_test.dir/depend.make

# Include the progress variables for this target.
include lm/CMakeFiles/model_test.dir/progress.make

# Include the compile flags for this target's objects.
include lm/CMakeFiles/model_test.dir/flags.make

lm/CMakeFiles/model_test.dir/model_test.cc.o: lm/CMakeFiles/model_test.dir/flags.make
lm/CMakeFiles/model_test.dir/model_test.cc.o: lm/model_test.cc
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/Users/post/code/joshua/src/kenlm/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object lm/CMakeFiles/model_test.dir/model_test.cc.o"
	cd /Users/post/code/joshua/src/kenlm/lm && /Applications/Xcode.app/Contents/Developer/usr/bin/g++   $(CXX_DEFINES) $(CXX_FLAGS) -o CMakeFiles/model_test.dir/model_test.cc.o -c /Users/post/code/joshua/src/kenlm/lm/model_test.cc

lm/CMakeFiles/model_test.dir/model_test.cc.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/model_test.dir/model_test.cc.i"
	cd /Users/post/code/joshua/src/kenlm/lm && /Applications/Xcode.app/Contents/Developer/usr/bin/g++  $(CXX_DEFINES) $(CXX_FLAGS) -E /Users/post/code/joshua/src/kenlm/lm/model_test.cc > CMakeFiles/model_test.dir/model_test.cc.i

lm/CMakeFiles/model_test.dir/model_test.cc.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/model_test.dir/model_test.cc.s"
	cd /Users/post/code/joshua/src/kenlm/lm && /Applications/Xcode.app/Contents/Developer/usr/bin/g++  $(CXX_DEFINES) $(CXX_FLAGS) -S /Users/post/code/joshua/src/kenlm/lm/model_test.cc -o CMakeFiles/model_test.dir/model_test.cc.s

lm/CMakeFiles/model_test.dir/model_test.cc.o.requires:

.PHONY : lm/CMakeFiles/model_test.dir/model_test.cc.o.requires

lm/CMakeFiles/model_test.dir/model_test.cc.o.provides: lm/CMakeFiles/model_test.dir/model_test.cc.o.requires
	$(MAKE) -f lm/CMakeFiles/model_test.dir/build.make lm/CMakeFiles/model_test.dir/model_test.cc.o.provides.build
.PHONY : lm/CMakeFiles/model_test.dir/model_test.cc.o.provides

lm/CMakeFiles/model_test.dir/model_test.cc.o.provides.build: lm/CMakeFiles/model_test.dir/model_test.cc.o


# Object files for target model_test
model_test_OBJECTS = \
"CMakeFiles/model_test.dir/model_test.cc.o"

# External object files for target model_test
model_test_EXTERNAL_OBJECTS = \
"/Users/post/code/joshua/src/kenlm/lm/CMakeFiles/kenlm.dir/bhiksha.cc.o" \
"/Users/post/code/joshua/src/kenlm/lm/CMakeFiles/kenlm.dir/binary_format.cc.o" \
"/Users/post/code/joshua/src/kenlm/lm/CMakeFiles/kenlm.dir/config.cc.o" \
"/Users/post/code/joshua/src/kenlm/lm/CMakeFiles/kenlm.dir/lm_exception.cc.o" \
"/Users/post/code/joshua/src/kenlm/lm/CMakeFiles/kenlm.dir/model.cc.o" \
"/Users/post/code/joshua/src/kenlm/lm/CMakeFiles/kenlm.dir/quantize.cc.o" \
"/Users/post/code/joshua/src/kenlm/lm/CMakeFiles/kenlm.dir/read_arpa.cc.o" \
"/Users/post/code/joshua/src/kenlm/lm/CMakeFiles/kenlm.dir/search_hashed.cc.o" \
"/Users/post/code/joshua/src/kenlm/lm/CMakeFiles/kenlm.dir/search_trie.cc.o" \
"/Users/post/code/joshua/src/kenlm/lm/CMakeFiles/kenlm.dir/sizes.cc.o" \
"/Users/post/code/joshua/src/kenlm/lm/CMakeFiles/kenlm.dir/trie.cc.o" \
"/Users/post/code/joshua/src/kenlm/lm/CMakeFiles/kenlm.dir/trie_sort.cc.o" \
"/Users/post/code/joshua/src/kenlm/lm/CMakeFiles/kenlm.dir/value_build.cc.o" \
"/Users/post/code/joshua/src/kenlm/lm/CMakeFiles/kenlm.dir/virtual_interface.cc.o" \
"/Users/post/code/joshua/src/kenlm/lm/CMakeFiles/kenlm.dir/vocab.cc.o" \
"/Users/post/code/joshua/src/kenlm/util/CMakeFiles/kenlm_util.dir/double-conversion/bignum-dtoa.cc.o" \
"/Users/post/code/joshua/src/kenlm/util/CMakeFiles/kenlm_util.dir/double-conversion/bignum.cc.o" \
"/Users/post/code/joshua/src/kenlm/util/CMakeFiles/kenlm_util.dir/double-conversion/cached-powers.cc.o" \
"/Users/post/code/joshua/src/kenlm/util/CMakeFiles/kenlm_util.dir/double-conversion/diy-fp.cc.o" \
"/Users/post/code/joshua/src/kenlm/util/CMakeFiles/kenlm_util.dir/double-conversion/double-conversion.cc.o" \
"/Users/post/code/joshua/src/kenlm/util/CMakeFiles/kenlm_util.dir/double-conversion/fast-dtoa.cc.o" \
"/Users/post/code/joshua/src/kenlm/util/CMakeFiles/kenlm_util.dir/double-conversion/fixed-dtoa.cc.o" \
"/Users/post/code/joshua/src/kenlm/util/CMakeFiles/kenlm_util.dir/double-conversion/strtod.cc.o" \
"/Users/post/code/joshua/src/kenlm/util/CMakeFiles/kenlm_util.dir/stream/chain.cc.o" \
"/Users/post/code/joshua/src/kenlm/util/CMakeFiles/kenlm_util.dir/stream/io.cc.o" \
"/Users/post/code/joshua/src/kenlm/util/CMakeFiles/kenlm_util.dir/stream/line_input.cc.o" \
"/Users/post/code/joshua/src/kenlm/util/CMakeFiles/kenlm_util.dir/stream/multi_progress.cc.o" \
"/Users/post/code/joshua/src/kenlm/util/CMakeFiles/kenlm_util.dir/stream/rewindable_stream.cc.o" \
"/Users/post/code/joshua/src/kenlm/util/CMakeFiles/kenlm_util.dir/bit_packing.cc.o" \
"/Users/post/code/joshua/src/kenlm/util/CMakeFiles/kenlm_util.dir/ersatz_progress.cc.o" \
"/Users/post/code/joshua/src/kenlm/util/CMakeFiles/kenlm_util.dir/exception.cc.o" \
"/Users/post/code/joshua/src/kenlm/util/CMakeFiles/kenlm_util.dir/file.cc.o" \
"/Users/post/code/joshua/src/kenlm/util/CMakeFiles/kenlm_util.dir/file_piece.cc.o" \
"/Users/post/code/joshua/src/kenlm/util/CMakeFiles/kenlm_util.dir/float_to_string.cc.o" \
"/Users/post/code/joshua/src/kenlm/util/CMakeFiles/kenlm_util.dir/integer_to_string.cc.o" \
"/Users/post/code/joshua/src/kenlm/util/CMakeFiles/kenlm_util.dir/mmap.cc.o" \
"/Users/post/code/joshua/src/kenlm/util/CMakeFiles/kenlm_util.dir/murmur_hash.cc.o" \
"/Users/post/code/joshua/src/kenlm/util/CMakeFiles/kenlm_util.dir/parallel_read.cc.o" \
"/Users/post/code/joshua/src/kenlm/util/CMakeFiles/kenlm_util.dir/pool.cc.o" \
"/Users/post/code/joshua/src/kenlm/util/CMakeFiles/kenlm_util.dir/read_compressed.cc.o" \
"/Users/post/code/joshua/src/kenlm/util/CMakeFiles/kenlm_util.dir/scoped.cc.o" \
"/Users/post/code/joshua/src/kenlm/util/CMakeFiles/kenlm_util.dir/string_piece.cc.o" \
"/Users/post/code/joshua/src/kenlm/util/CMakeFiles/kenlm_util.dir/usage.cc.o"

bin/model_test: lm/CMakeFiles/model_test.dir/model_test.cc.o
bin/model_test: lm/CMakeFiles/kenlm.dir/bhiksha.cc.o
bin/model_test: lm/CMakeFiles/kenlm.dir/binary_format.cc.o
bin/model_test: lm/CMakeFiles/kenlm.dir/config.cc.o
bin/model_test: lm/CMakeFiles/kenlm.dir/lm_exception.cc.o
bin/model_test: lm/CMakeFiles/kenlm.dir/model.cc.o
bin/model_test: lm/CMakeFiles/kenlm.dir/quantize.cc.o
bin/model_test: lm/CMakeFiles/kenlm.dir/read_arpa.cc.o
bin/model_test: lm/CMakeFiles/kenlm.dir/search_hashed.cc.o
bin/model_test: lm/CMakeFiles/kenlm.dir/search_trie.cc.o
bin/model_test: lm/CMakeFiles/kenlm.dir/sizes.cc.o
bin/model_test: lm/CMakeFiles/kenlm.dir/trie.cc.o
bin/model_test: lm/CMakeFiles/kenlm.dir/trie_sort.cc.o
bin/model_test: lm/CMakeFiles/kenlm.dir/value_build.cc.o
bin/model_test: lm/CMakeFiles/kenlm.dir/virtual_interface.cc.o
bin/model_test: lm/CMakeFiles/kenlm.dir/vocab.cc.o
bin/model_test: util/CMakeFiles/kenlm_util.dir/double-conversion/bignum-dtoa.cc.o
bin/model_test: util/CMakeFiles/kenlm_util.dir/double-conversion/bignum.cc.o
bin/model_test: util/CMakeFiles/kenlm_util.dir/double-conversion/cached-powers.cc.o
bin/model_test: util/CMakeFiles/kenlm_util.dir/double-conversion/diy-fp.cc.o
bin/model_test: util/CMakeFiles/kenlm_util.dir/double-conversion/double-conversion.cc.o
bin/model_test: util/CMakeFiles/kenlm_util.dir/double-conversion/fast-dtoa.cc.o
bin/model_test: util/CMakeFiles/kenlm_util.dir/double-conversion/fixed-dtoa.cc.o
bin/model_test: util/CMakeFiles/kenlm_util.dir/double-conversion/strtod.cc.o
bin/model_test: util/CMakeFiles/kenlm_util.dir/stream/chain.cc.o
bin/model_test: util/CMakeFiles/kenlm_util.dir/stream/io.cc.o
bin/model_test: util/CMakeFiles/kenlm_util.dir/stream/line_input.cc.o
bin/model_test: util/CMakeFiles/kenlm_util.dir/stream/multi_progress.cc.o
bin/model_test: util/CMakeFiles/kenlm_util.dir/stream/rewindable_stream.cc.o
bin/model_test: util/CMakeFiles/kenlm_util.dir/bit_packing.cc.o
bin/model_test: util/CMakeFiles/kenlm_util.dir/ersatz_progress.cc.o
bin/model_test: util/CMakeFiles/kenlm_util.dir/exception.cc.o
bin/model_test: util/CMakeFiles/kenlm_util.dir/file.cc.o
bin/model_test: util/CMakeFiles/kenlm_util.dir/file_piece.cc.o
bin/model_test: util/CMakeFiles/kenlm_util.dir/float_to_string.cc.o
bin/model_test: util/CMakeFiles/kenlm_util.dir/integer_to_string.cc.o
bin/model_test: util/CMakeFiles/kenlm_util.dir/mmap.cc.o
bin/model_test: util/CMakeFiles/kenlm_util.dir/murmur_hash.cc.o
bin/model_test: util/CMakeFiles/kenlm_util.dir/parallel_read.cc.o
bin/model_test: util/CMakeFiles/kenlm_util.dir/pool.cc.o
bin/model_test: util/CMakeFiles/kenlm_util.dir/read_compressed.cc.o
bin/model_test: util/CMakeFiles/kenlm_util.dir/scoped.cc.o
bin/model_test: util/CMakeFiles/kenlm_util.dir/string_piece.cc.o
bin/model_test: util/CMakeFiles/kenlm_util.dir/usage.cc.o
bin/model_test: lm/CMakeFiles/model_test.dir/build.make
bin/model_test: /opt/local/lib/libboost_program_options-mt.dylib
bin/model_test: /opt/local/lib/libboost_system-mt.dylib
bin/model_test: /opt/local/lib/libboost_thread-mt.dylib
bin/model_test: /opt/local/lib/libboost_unit_test_framework-mt.dylib
bin/model_test: lm/CMakeFiles/model_test.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/Users/post/code/joshua/src/kenlm/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable ../bin/model_test"
	cd /Users/post/code/joshua/src/kenlm/lm && $(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/model_test.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
lm/CMakeFiles/model_test.dir/build: bin/model_test

.PHONY : lm/CMakeFiles/model_test.dir/build

lm/CMakeFiles/model_test.dir/requires: lm/CMakeFiles/model_test.dir/model_test.cc.o.requires

.PHONY : lm/CMakeFiles/model_test.dir/requires

lm/CMakeFiles/model_test.dir/clean:
	cd /Users/post/code/joshua/src/kenlm/lm && $(CMAKE_COMMAND) -P CMakeFiles/model_test.dir/cmake_clean.cmake
.PHONY : lm/CMakeFiles/model_test.dir/clean

lm/CMakeFiles/model_test.dir/depend:
	cd /Users/post/code/joshua/src/kenlm && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /Users/post/code/joshua/src/kenlm /Users/post/code/joshua/src/kenlm/lm /Users/post/code/joshua/src/kenlm /Users/post/code/joshua/src/kenlm/lm /Users/post/code/joshua/src/kenlm/lm/CMakeFiles/model_test.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : lm/CMakeFiles/model_test.dir/depend
