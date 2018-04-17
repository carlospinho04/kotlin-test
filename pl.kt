package my.package.android.bluetooth

import android.app.Application
import dagger.Module
import dagger.Provides
import my.package.bluetoothsdk.Logger
import my.package.bluetoothsdk.RealRxBluetooth
import my.package.bluetoothsdk.RxBluetooth
import timber.log.Timber
import javax.inject.Singleton

/**
 * <br>
 * FAMILO GmbH
 *
 * @author niklasbaudy / vanniktech
 * @since 07.07.17
 */
@Module class BluetoothModule {
  @Provides @Singleton internal fun provideRxPermissions(application: Application): RxBluetooth {
    return RealRxBluetooth(application, object : Logger {
      override fun d(message: String) {
        Timber.d(message)
      }
    })
  }
}