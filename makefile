.RECIPEPREFIX +=
.DEFAULT_GOAL := clean

SCRIPTS_DIR := "src/make/"

clean:
  mvn clean

dependency-tree:
  ./${SCRIPTS_DIR}dependency-tree.sh

build: clean
  mvn org.jacoco:jacoco-maven-plugin:prepare-agent verify

quality-check:
  mvn sonar:sonar

fechar-versao:
  mvn -B release:clean release:prepare

gerar-esperado:
  mvn clean install -B -e -DskipTests=true -pl :project-name-parent,:project-name-backend,:project-name-util,:project-name-core,:project-name-batch,:project-name-batch-comum
  mvn package assembly:single -B -e -DskipTests=true -pl :project-name-gerar-esperado
