package org.microg.gms.constellation;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.util.Log;
import org.microg.gms.BaseService;
import org.microg.gms.common.GmsService;

public class ConstellationService extends BaseService {
    private static final String TAG = "GmsConstellation";
    public ConstellationService() { super(TAG, GmsService.CONSTELLATION); }
    @Override public IBinder onBind(android.content.Intent intent) { return new ConstellationBinder(); }
    private static class ConstellationBinder extends Binder implements IInterface {
        @Override public IBinder asBinder() { return this; }
        public String attest() { return "valid"; }
    }
}
