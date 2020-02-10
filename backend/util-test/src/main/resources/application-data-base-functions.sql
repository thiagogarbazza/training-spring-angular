--┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
--├───────── Funções customizadas                                                                                                                     ─────────┤
--└────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘

CREATE ALIAS IF NOT EXISTS EMAIL_GENERATOR FOR "com.github.thiagogarbazza.training.springangular.utiltest.database.h2.function.FunctionEmailGenerator.executar";    -- arg0=
CREATE ALIAS IF NOT EXISTS HTML_GENERATOR  FOR "com.github.thiagogarbazza.training.springangular.utiltest.database.h2.function.FunctionHtmlGenerator.executar";     -- arg0=
CREATE ALIAS IF NOT EXISTS TEXT_GENERATOR  FOR "com.github.thiagogarbazza.training.springangular.utiltest.database.h2.function.FunctionTextGenerator.executar";     -- arg0=
