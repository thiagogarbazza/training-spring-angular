.PHONY: show-help
show-help:
  @echo "╔═════════════════════════════════════════════════════════════════════════╗"
  @echo "╠═════════                       Make help                       ═════════╣"
  @echo "╚═════════════════════════════════════════════════════════════════════════╝"
  @echo "Usage: make [\033[36mtarget\033[0m] [options]"
  @echo ""
  @echo "$$(tput bold)Available targets:$$(tput sgr0)"
  @echo
  @awk '{ \
      if ($$0 ~ /^.PHONY: [a-zA-Z\-\_0-9]+$$/) { \
        helpCommand = substr($$0, index($$0, ":") + 2); \
        if (helpMessage) { \
          printf "  - \033[36m%s:\033[0m\n", helpCommand; \
          printf "%-10s%s\n", " ", helpMessage; \
          helpMessage = ""; \
        } \
      } else if ($$0 ~ /^[a-zA-Z\-\_0-9.]+:/) { \
        helpCommand = substr($$0, 0, index($$0, ":")); \
        if (helpMessage) { \
          printf "  - \033[36m%s\033[0m\n", helpCommand; \
          printf "%-10s%s\n", " ", helpMessage; \
          helpMessage = ""; \
        } \
      } else if ($$0 ~ /^##/) { \
        if (helpMessage) { \
          helpMessage = helpMessage"\n          "substr($$0, 3); \
        } else { \
          helpMessage = substr($$0, 3); \
        } \
      } else { \
        if (helpMessage) { \
          print "\n         "helpMessage"\n" \
        } \
        helpMessage = ""; \
      } \
    }' \
    $(MAKEFILE_LIST)
