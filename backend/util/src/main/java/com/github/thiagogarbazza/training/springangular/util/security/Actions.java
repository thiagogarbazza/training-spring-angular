package com.github.thiagogarbazza.training.springangular.util.security;

import java.util.TreeMap;

public class Actions extends TreeMap<String, Action> {

  public static final String ACTION_CAN_CREATE = "canCreate";
  public static final String ACTION_CAN_DELETE = "canDelete";
  public static final String ACTION_CAN_REPORT_EXCEL = "canReportExcel";
  public static final String ACTION_CAN_SEARCH = "canSearch";
  public static final String ACTION_CAN_UPDATE = "canUpdate";
}
