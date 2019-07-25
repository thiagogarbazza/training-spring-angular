.RECIPEPREFIX +=
.DEFAULT_GOAL := clean

VARIABLE := "src/make/"

clean:
  ./${VARIABLE}clean.sh

dependency-tree:
  mvn dependency:tree

quality-check:
  mvn org.jacoco:jacoco-maven-plugin:prepare-agent verify
  mvn sonar:sonar

fechar-versao:
  
  
