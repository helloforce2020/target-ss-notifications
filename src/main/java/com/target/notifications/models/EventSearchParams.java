package com.target.notifications.models;

/**
 * Model for search over events created.
 * 
 * @author vinaymajety
 *
 */
public class EventSearchParams {

  private String name;
  private String businessUnit;
  private String id;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getBusinessUnit() {
    return businessUnit;
  }

  public void setBusinessUnit(String businessUnit) {
    this.businessUnit = businessUnit;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

}
