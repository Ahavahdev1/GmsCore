/*
 * Copyright (C) 2013-2026 microG Project Team
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.microg.gms.common;

import android.content.Context;
import android.telephony.TelephonyManager;
import java.util.Random;

public class PhoneInfo {
    public String cellOperator = "26207";
    public String roaming = "mobile-notroaming";
    public String simOperator = "26207";
    public String imsi = randomImsi();

    public PhoneInfo() {
        // Construtor padrão exigido pelo ecossistema
    }

    public PhoneInfo(Context context) {
        if (context != null) {
            try {
                TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
                if (tm != null) {
                    String networkOperator = tm.getNetworkOperator();
                    if (networkOperator != null && networkOperator.length() >= 5) {
                        this.cellOperator = networkOperator;
                    }
                    String simOp = tm.getSimOperator();
                    if (simOp != null && simOp.length() >= 5) {
                        this.simOperator = simOp;
                    }
                    if (tm.isNetworkRoaming()) {
                        this.roaming = "mobile-roaming";
                    }
                    this.imsi = randomImsi();
                }
            } catch (Exception ignored) {
                // Mantém o fallback padrão de testes caso falte permissão
            }
        }
    }

    private String randomImsi() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(simOperator);
        while (sb.length() < 15) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }
}
