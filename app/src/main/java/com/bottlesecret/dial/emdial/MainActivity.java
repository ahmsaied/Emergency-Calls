package com.bottlesecret.dial.emdial;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    private CardView crdPolice , crdAmbulance , crdFire , crdElectricity , crdNatGas , crdNTRA ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        crdPolice = (CardView)findViewById(R.id.crd_police);
        crdAmbulance = (CardView)findViewById(R.id.crd_ambulance);
        crdFire = (CardView)findViewById(R.id.crd_fire);
        crdElectricity = (CardView)findViewById(R.id.crd_electricity);
        crdNatGas = (CardView)findViewById(R.id.crd_nat_gas);
        crdNTRA = (CardView)findViewById(R.id.crd_ntra);

        crdPolice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CallPolice();
            }
        });

        crdAmbulance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CallAmbulance();
            }
        });

        crdFire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CallFireDepartment();
            }
        });

        crdElectricity.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               CallElectricityEmergency();
           }
       });

        crdNatGas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CallNaturalGasEmergency();
            }
        });

        crdNTRA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CallNTRA();
            }
        });
    }

    private void CallPolice() {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel: 122"));
        if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(intent);
    }

    public void CallAmbulance() {
        Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel: 123"));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(i);
    }

    public void CallFireDepartment() {
        Intent x = new Intent(Intent.ACTION_CALL, Uri.parse("tel: 180"));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(x);
    }

    public void CallElectricityEmergency() {
        Intent z = new Intent(Intent.ACTION_CALL, Uri.parse("tel: 121"));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(z);
    }

    public void CallNaturalGasEmergency() {
        Intent a = new Intent(Intent.ACTION_CALL, Uri.parse("tel: 129"));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(a);
    }

    public void CallNTRA() {
        Intent e = new Intent(Intent.ACTION_CALL, Uri.parse("tel: 155"));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(e);
    }
}
