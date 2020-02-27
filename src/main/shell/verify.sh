#!/bin/bash
set -euo pipefail

mvn -B -e -U \
  verify
