package app.aaps.pump.common.hw.rileylink.ble;

import app.aaps.pump.common.hw.rileylink.ble.defs.RileyLinkBLEError;

/**
 * Created by andy on 11/23/18.
 */

public class RileyLinkCommunicationException extends Exception {

    String extendedErrorText;
    private final RileyLinkBLEError errorCode;


    public RileyLinkCommunicationException(RileyLinkBLEError errorCode, String extendedErrorText) {
        super(errorCode.getDescription());

        this.errorCode = errorCode;
        this.extendedErrorText = extendedErrorText;
    }


    public RileyLinkCommunicationException(RileyLinkBLEError errorCode) {
        super(errorCode.getDescription());

        this.errorCode = errorCode;
        // this.extendedErrorText = extendedErrorText;
    }

    public RileyLinkBLEError getErrorCode() {
        return errorCode;
    }
}
