package com.github.thiagogarbazza.training.springangular.util.security;

import java.util.TreeMap;

public class Actions extends TreeMap<String, Action> {

  public static final String ACTION_CAN_CREATE = "doCreate";
  public static final String ACTION_CAN_DELETE = "doDelete";
  public static final String ACTION_CAN_DETAIL = "doDetail";
  public static final String ACTION_CAN_REPORT_EXCEL = "doReportExcel";
  public static final String ACTION_CAN_SEARCH = "doSearch";
  public static final String ACTION_CAN_UPDATE = "doUpdate";
}
