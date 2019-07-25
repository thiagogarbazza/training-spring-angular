.RECIPEPREFIX +=
.DEFAULT_GOAL := clean

SCRIPTS_DIR := "src/make/"

clean:
  mvn clean

dependency-tree:
  ./${SCRIPTS_DIR}dependency-tree.sh

build:
  mvn org.jacoco:jacoco-maven-plugin:prepare-agent verify

quality-check:
  mvn sonar:sonar

fechar-versao:
  mvn -B release:clean release:prepare

