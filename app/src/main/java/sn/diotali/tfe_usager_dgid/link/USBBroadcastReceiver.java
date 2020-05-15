/*
 * ============================================================================
 * COPYRIGHT
 *              Pax CORPORATION PROPRIETARY INFORMATION
 *   This software is supplied under the terms of a license agreement or
 *   nondisclosure agreement with Pax Corporation and may not be copied
 *   or disclosed except in accordance with the terms in that agreement.
 *      Copyright (C) 2016 - ? Pax Corporation. All rights reserved.
 * Module Date: 2017-9-8
 * Module Author: lixc
 * Description:
 *
 * ============================================================================
 */
package sn.diotali.tfe_usager_dgid.link;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.UsbManager;

public class USBBroadcastReceiver extends BroadcastReceiver {

    private OnUsbListener usbListener;

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (UsbManager.ACTION_USB_DEVICE_DETACHED.equals(action)) {
            usbListener.onUsbDetached();
        } else if (UsbManager.ACTION_USB_DEVICE_ATTACHED.equals(action)) {
            usbListener.onUsbAttached();
        }
    }

    public void registerUsbReceiver(Context context) {
        IntentFilter filter = new IntentFilter();
        filter.addAction(UsbManager.ACTION_USB_DEVICE_ATTACHED);
        filter.addAction(UsbManager.ACTION_USB_DEVICE_DETACHED);
        context.registerReceiver(this, filter);
    }

    public void unregisterUsbReceiver(Context context) {
        context.unregisterReceiver(this);
    }

    public void setUsbListener(OnUsbListener usbListener) {
        this.usbListener = usbListener;
    }

    public interface OnUsbListener {
        void onUsbDetached();

        void onUsbAttached();
    }
}
