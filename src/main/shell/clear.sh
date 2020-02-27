#!/bin/bash
set -euo pipefail

mvn -B -e -U \
  -DskipTests=true \
  clean
