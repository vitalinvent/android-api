package ru.kassatka.comepay_sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.util.UUID;

public class CheckUpdatesReceiver extends BroadcastReceiver {
  private static final String UPDATED_POSITION_COUNT = "ru.kassa.action.position.update.count";
  private static final String UPDATED_POSITION_PRICE = "ru.kassa.action.position.update.price";
  private static final String UPDATED_POSITION_NAME = "ru.kassa.action.position.update.name";
  private static final String POSITION_ADDED = "ru.kassa.action.position.add";
  private static final String POSITION_REMOVED = "ru.kassa.action.position.removed";
  private static final String POSITION_ID = "UUID";
  private static final String COUNT = "COUNT";
  private static final String PRICE = "PRICE";
  private static final String NAME = "NAME";
  private static final String POSITION_EXTERNAL_ID = "POSITION";

  Listener listener;

  public CheckUpdatesReceiver() {
    listener =
        new Listener() {
          @Override
          public void countUpdated(UUID uuid, Double count) {
          }

          @Override
          public void priceUpdated(UUID uuid, Double price) {
          }

          @Override
          public void nameUpdated(UUID uuid, String name) {
          }

          @Override
          public void positionAdded(UUID uuid, String positionExternalId) {
          }

          @Override
          public void positionRemoved(UUID uuid) {
          }
        };
  }

  public CheckUpdatesReceiver(Listener listener) {
    this.listener = listener;
  }

  @Override
  public void onReceive(Context context, Intent intent) {
    String action = intent.getAction();
    UUID uuid;
    switch (action) {
      case UPDATED_POSITION_COUNT:
        uuid = (UUID) intent.getSerializableExtra(POSITION_ID);
        Double count = intent.getDoubleExtra(COUNT, 0.0);
        listener.countUpdated(uuid, count);
        break;
      case UPDATED_POSITION_PRICE:
        uuid = (UUID) intent.getSerializableExtra(POSITION_ID);
        Double price = intent.getDoubleExtra(PRICE, 0.0);
        listener.priceUpdated(uuid, price);
        break;
      case UPDATED_POSITION_NAME:
        uuid = (UUID) intent.getSerializableExtra(POSITION_ID);
        String name = intent.getStringExtra(NAME);
        listener.nameUpdated(uuid, name);
        break;
      case POSITION_ADDED:
        uuid = (UUID) intent.getSerializableExtra(POSITION_ID);
        String positionExternalId = intent.getStringExtra(POSITION_EXTERNAL_ID);
        listener.positionAdded(uuid, positionExternalId);
        break;
      case POSITION_REMOVED:
        uuid = (UUID) intent.getSerializableExtra(POSITION_ID);
        listener.positionRemoved(uuid);
        break;
      default:
    }
  }

  public interface Listener {
    void countUpdated(UUID uuid, Double count);

    void priceUpdated(UUID uuid, Double price);

    void nameUpdated(UUID uuid, String name);

    void positionAdded(UUID uuid, String positionExternalId);

    void positionRemoved(UUID uuid);
  }
}
