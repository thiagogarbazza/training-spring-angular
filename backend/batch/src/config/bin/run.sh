#!/bin/bash
set -euo pipefail
exec &> >(tee -a "/tmp/app-build.log") 2>&1

########################################################################################################################
#########   Registering                                                                                        #########
########################################################################################################################
TIMESTAMP_START=$(TZ=$TIMEZONE date +%s)
FILE_NAME_LOG="${project.artifactId}-$(TZ=$TIMEZONE date -d@$TIMESTAMP_START -u +"%Y-%m-%d-%H-%M-%S")"

# Hack for get the directory on lives script.
SCRIPTPATH="$( cd "$(dirname "$0")/.." ; pwd -P )"
cd "$SCRIPTPATH"

# Redirecting logging to file and terminal
mkdir -p logs/
exec &> >(tee -a "logs/$FILE_NAME_LOG.log") 2>&1

# Search if there is already any execution
# $(echo $0 | ps -ef | grep "${project.artifactId}" | grep "java")
RUNNING_WITH_PID=""

if [ "$RUNNING_WITH_PID" != "" ]; then
  echo "Application is already running with PID '$RUNNING_WITH_PID'."
  EXIT_CODE=${batch.execution.exit-code.another-instance-is-running}
else
  ######################################################################################################################
  #########   Setting up                                                                                       #########
  ######################################################################################################################
  CONFIG_TIMEZONE="-Duser.timezone=$TIMEZONE"
  CONFIG_MEMORY="-XX:PermSize=128m -XX:MaxPermSize=4096m -DXms128m -DXmx4096m"

  # Class path
  ##################################################
  CONFIG_CLASS_PATH=""

  # Adding dependencies from the libs directory
  for lib in ./lib/*.jar; do
    CONFIG_CLASS_PATH="$CONFIG_CLASS_PATH:$lib"
  done

  # Adding resources from the common directory
  for resource in ./resources/comum/*; do
    CONFIG_CLASS_PATH="$CONFIG_CLASS_PATH:$resource"
  done

  # Adding resources from the enviroment directory
  for resource in ./resources/$ENV/*; do
    CONFIG_CLASS_PATH="$CONFIG_CLASS_PATH:$resource"
  done

  echo "╔═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════"
  echo "╠═════════  Application ${project.artifactId} execution information on $(TZ=$TIMEZONE date -d@$TIMESTAMP_START -u +"%Y/%m/%d %H:%M:%S.%3N")"
  echo "╠═════════"
  echo "╠═════════  Project version: ${project.version} at ${project.version.timestamp}"
  echo "╠═════════"
  echo "╠═════════  Enviroment information:"
  echo "╠═════════    - Name: $ENV"
  echo "╠═════════    - Main execution: ${batch.execution.main}"
  echo "╠═════════    - Java home: $JAVA_HOME"
  echo "╠═════════    - Timezone: $CONFIG_TIMEZONE"
  echo "╠═════════    - Memory: $CONFIG_MEMORY"
  echo "╠═════════    - Class path: $CONFIG_CLASS_PATH"
  echo "╚═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════"

  $JAVA_HOME/bin/java $CONFIG_TIMEZONE -classpath $CONFIG_CLASS_PATH $CONFIG_MEMORY com.github.thiagogarbazza.trainings.unittest.ExampleMain
  EXIT_CODE=$?
fi

TIMESTAMP_FINISH=$(TZ=$TIMEZONE date +%s)
TIMESTAMP_SPENT=$(( TIMESTAMP_FINISH - TIMESTAMP_START ))

echo ""
echo "exit-code = $EXIT_CODE"
echo "╔═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗"
echo "╠═════════  Time spent to run application: $(date -d@$TIMESTAMP_SPENT -u +"%H:%M:%S.%3N")                                                              ═════════╣"
echo "╚═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝"

########################################################################################################################
#########   Ending                                                                                             #########
########################################################################################################################
#tar -cvf logs/$FILE_NAME_LOG.tar logs/$FILE_NAME_LOG*.log
# $QUARTZ_HOME/bin/jcifscopy.sh $FILE_NAME_LOG.tar SMB:CRD_LOG
# rm -f $FILE_NAME_LOG.tar

exit $EXIT_CODE
