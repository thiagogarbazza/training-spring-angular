.RECIPEPREFIX +=
.DEFAULT_GOAL := show-help

include src/main/make/show-help.mk

SCRIPTS_DIR := "src/main/shell"

clear:
  ./${SCRIPTS_DIR}/clear.sh

dependency-tree:
  ./${SCRIPTS_DIR}dependency-tree.sh

build:
  ./${SCRIPTS_DIR}/build.sh

quality-check:
  mvn sonar:sonar

release-prepare:
  ./${SCRIPTS_DIR}/release-prepare.sh

verify:
  ./${SCRIPTS_DIR}/verify.sh


## Lorem Ipsum job 03 is simply dummy text
## of the printing and typesetting industry.
## Lorem Ipsum has been the industry's standard
## dummy text ever since the 1500s,
## when an unknown printer took a galley of type
## and scrambled it to make a type specimen book.
job3:
  @echo "job 3"

## Lorem Ipsum job 02 is simply dummy text of the
## printing and typesetting industry.
job2:
  @echo "job 2"

## Lorem Ipsum job 01 is simply dummy text of the
## printing and typesetting industry.
.PHONY: job1
job1:
  @echo "job 1"

job0:
  @echo "job 0"
