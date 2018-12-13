package ru.kassatka.comepay_sdk.loyalty.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Device status response from kassatka urls.
 */
public class DeviceStatus implements Serializable {

  public boolean success;

  public boolean notFound = false;
  public Device device;

  @SerializedName("work_place")
  public WorkPlace workPlace;

  public Store store;
  public Organization organization;
  public Account account;

  @SerializedName("timezone")
  public Integer timezone;

  /**
   * Measure the connection of the device with the workplace
   *
   * @return - true if device linked with workplace and false otherwise.
   */
  public boolean isLinked() {
    return (workPlace != null) && (workPlace.id != null);
  }

  /**
   * Check that device is valid.
   *
   * @return - true if device and its id not null and false otherwise.
   */
  public boolean isValid() {
    return (device != null) && (device.id != null);
  }

  public boolean isClientPanel() {
    return isLinked()
        && workPlace.workplaceType != null
        && workPlace.workplaceType.equals(WorkplaceTypes.CLIENT);
  }

  public boolean isProducer() {
    return isLinked()
        && workPlace.workplaceType != null
        && (workPlace.workplaceType.equals(WorkplaceTypes.WORKMAN)
        || workPlace.workplaceType.equals(WorkplaceTypes.BAKER));
  }

  public static class Device {
    public Integer id;
  }

  public static class WorkPlace {
    public Integer id;

    @SerializedName("store_id")
    public Integer storeId;

    public String name;
    public String idt;

    @SerializedName("device_id")
    public Integer deviceId;

    @SerializedName("workplace_type")
    public String workplaceType;

    @SerializedName("workplace_url")
    public String workplaceUrl;
  }

  public static class Store {
    public Long id;

    @SerializedName("account_id")
    public Integer accountId;

    @SerializedName("organization_id")
    public Integer organizationId;

    @SerializedName("town_id")
    public Integer townId;

    public String name;
    public String addres;
  }

  public static class Organization {
    public Integer id;

    @SerializedName("account_id")
    public String accountId;

    public String name;

    @SerializedName("form_id")
    public Integer formId;

    public String inn;
    public String ogrn;

    @SerializedName("legal_address")
    public String legalAddress;
  }

  public static class Account {
    public Integer id;
    public String name;
    public String idt;
  }
}
