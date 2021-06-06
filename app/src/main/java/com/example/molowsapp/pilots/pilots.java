package com.example.molowsapp.pilots;

import android.os.Parcel;
import android.os.Parcelable;

public class pilots  implements Parcelable {
    private String name;
    private String nickName;
    private String team;
    private String description;
    private int idImagenPais;
    private int idImagenPilot;

    public pilots(String name, String nickName, String team, String description, int idImagenPais, int idImagenPilot) {
        this.name = name;
        this.nickName = nickName;
        this.team = team;
        this.description = description;
        this.idImagenPais = idImagenPais;
        this.idImagenPilot = idImagenPilot;
    }

    protected pilots(Parcel in) {
        name = in.readString();
        nickName = in.readString();
        team = in.readString();
        description = in.readString();
        idImagenPais = in.readInt();
        idImagenPilot = in.readInt();
    }

    public static final Creator<pilots> CREATOR = new Creator<pilots>() {
        @Override
        public pilots createFromParcel(Parcel in) {
            return new pilots(in);
        }

        @Override
        public pilots[] newArray(int size) {
            return new pilots[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(nickName);
        dest.writeString(team);
        dest.writeString(description);
        dest.writeInt(idImagenPais);
        dest.writeInt(idImagenPilot);
    }

    public String getName() {
        return name;
    }

    public String getNickName() {
        return nickName;
    }

    public String getTeam() {
        return team;
    }

    public String getDescription() {
        return description;
    }

    public int getIdImagenPais() {
        return idImagenPais;
    }

    public int getIdImagenPilot() {
        return idImagenPilot;
    }
}
