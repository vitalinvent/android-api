package ru.kassatka.loyalty_4client.loyalty.models;

/** Enum for different workplaces enumeration */
public enum WorkplaceTypes {
  WORKPLACE("WORKPLACE"),
  CLIENT("CLIENT"),
  ROOM("ROOM"),
  WORKMAN("WORKMAN"),
  BAKER("BAKER");

  String workplace;

  WorkplaceTypes(String workplace) {
    this.workplace = workplace;
  }
}
