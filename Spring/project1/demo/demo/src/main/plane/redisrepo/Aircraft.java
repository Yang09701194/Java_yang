package main.plane.redisrepo;

import com.example.app.Droid;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import javax.persistence.Id;
//import javax.persistence.Entity;
import java.time.Instant;

//@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Aircraft {

//    @Id
//    public long id;

    private String callsign, squwak, reg, flightno, route, type, category;
    private int altitude, heading, speed;

    @JsonProperty("vert_rate")
    private int vertRate;
    @JsonProperty("selected_altitude")
    private int selectedAltitude;
    private double lat, lon, barometer;
    @JsonProperty("polar_distance")
    private double polarDistance;
    @JsonProperty("polar_bearing")
    private double polarBearing;

    @JsonProperty("is_adsb")
    private boolean isADSB;
    @JsonProperty("is_on_ground")
    private boolean isOnGround;

    @JsonProperty("last_seen_time")
    private Instant lastSeenTime;
    @JsonProperty("pos_update_time")
    private Instant posUpdateTime;
    @JsonProperty("bds40_seen_time")
    private Instant bds40SeenTime;

    public String getLastSeemTime(){
        return lastSeenTime.toString();
    }

    public void setLastSeenTime(String lastSeenTime){
        if(null != lastSeenTime){
            this.lastSeenTime = Instant.parse(lastSeenTime);
        } else{
            this.lastSeenTime = Instant.ofEpochSecond(0);
        }
    }

    public String getPostUpdateTime(){
        return posUpdateTime.toString();
    }

    public void setPostUpdateTime(String posUpdateTime){
        if(null != posUpdateTime){
            this.posUpdateTime =Instant.parse(posUpdateTime);
        } else{
            this.posUpdateTime = Instant.ofEpochSecond(0);
        }
    }

    public Instant getBds40SeenTime() {
        return bds40SeenTime;
    }

    public void setBds40SeenTime(String bds40SeenTime) {
        if(null != bds40SeenTime){
            this.bds40SeenTime =Instant.parse(bds40SeenTime);
        } else{
            this.bds40SeenTime = Instant.ofEpochSecond(0);
        }
    }
}



