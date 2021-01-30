package info.nightscout.androidaps.utils.extensions

import android.os.Bundle
import android.os.Parcel
import android.util.Base64
import androidx.work.Data
import info.nightscout.androidaps.MainApp

fun Data.Builder.copyString(key: String, bundle:  Bundle?, defaultValue : String? = ""): Data.Builder =
    this.also { putString(key, bundle?.getString(key) ?: defaultValue) }

fun Data.Builder.copyLong(key: String, bundle:  Bundle?, defaultValue : Long = 0): Data.Builder =
    this.also { putLong(key, bundle?.getLong(key) ?: defaultValue) }

fun Data.Builder.copyInt(key: String, bundle:  Bundle?, defaultValue : Int = 0): Data.Builder =
    this.also { putInt(key, bundle?.getInt(key) ?: defaultValue) }

fun Data.Builder.copyDouble(key: String, bundle:  Bundle?, defaultValue : Double = 0.0): Data.Builder =
    this.also { putDouble(key, bundle?.getDouble(key) ?: defaultValue) }

fun Bundle.toBase64(): String {
    val parcel = Parcel.obtain()
    parcel.writeBundle(this)
    val bytes = parcel.marshall()
    parcel.recycle()
    return Base64.encodeToString(bytes, 0)
}

fun fromBase64(base64Bundle: String): Bundle {
    val bytes = Base64.decode(base64Bundle, 0)
    val parcel = Parcel.obtain()
    parcel.unmarshall(bytes, 0, bytes.size)
    parcel.setDataPosition(0)
    val bundle = parcel.readBundle(MainApp::class.java.classLoader)
    parcel.recycle()
    return bundle
}
