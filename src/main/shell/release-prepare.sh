#!/bin/bash
set -euo pipefail

mvn -B -e -U \
  -DskipTests=true \
  release:clean release:prepare
