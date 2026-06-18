//WID(29/05/2026)(Sarthak Mittal(DegamieSign)#1.1.1
package com.kafka.Carofly.dto;

//import com.networknt.schema.format.TimeFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="PLAYER")
public class PlayerProducer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="playerid",unique = true,nullable = false)
    public String playerId;
    @Column(name="playername",unique = false,nullable=true)
    public String playername;
//    @Column(name="flighttime",unique = false,nullable=true)
//    public TimeFormat playerFlightTime;
    @Column(name="score",unique = false, nullable=true)
    public  int score;
    @Column(name="logoutdate",unique = false,nullable=true)
    public LocalTime playermodifieddate;
    @Column(name="plaayerspeedaccuracy",unique = false,nullable=true)
    public  Integer plaayerspeedaccuracy;

}


////    @Column(name="logintime",unique = false)
//    public LocalTime  loginTime;
////    @Column(name="logoutTime",unique = false)
//    public LocalTime  logoutTime;
////    @Column(name="loginate",unique = false)
//    public SimpleDateFormat playercrdate;

////    @Column(name="playeremail",unique = false)
//    public LocalTime  email;

