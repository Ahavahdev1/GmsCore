package org.microg.gms.asterism;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.util.Log;
import org.microg.gms.BaseService;
import org.microg.gms.common.GmsService;

public class AsterismService extends BaseService {
    private static final String TAG = "GmsAsterism";
    public AsterismService() { super(TAG, GmsService.ASTERISM); }
    @Override public IBinder onBind(android.content.Intent intent) { return new AsterismBinder(); }
    private static class AsterismBinder extends Binder implements IInterface {
        @Override public IBinder asBinder() { return this; }
        public boolean bypass() { return true; }
    }
}
