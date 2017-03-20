package com.zeus.vibin.conv.button.packetexchange;

import com.zeus.vibin.conv.button.constants.Constants;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by cyber on 22-Feb-17.
 */
public class Conversion implements PacketInterface {

    private String json;
    private JSONObject jsonObject;
    private JSONObject packetsObject;

    public Conversion() { fetchPackets(); }

    public void fetchPackets(){

        try {
            json = new PacketApiDownloader().execute(Constants.packetApi).get();
            jsonObject = new JSONObject(json);
            packetsObject = jsonObject.getJSONObject("packets");
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    public double getPacketSize(String units) {
        double r = 0d;
        try
        {
            r = packetsObject.getDouble(units);

        }
        catch (JSONException e) {
            e.printStackTrace();
        }
        return r;
    }

}
