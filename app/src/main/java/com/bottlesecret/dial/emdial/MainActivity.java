package com.bottlesecret.dial.emdial;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;


public class MainActivity extends AppCompatActivity {

    private CardView crdPolice, crdAmbulance, crdFire, crdElectricity, crdNatGas, crdNTRA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // checking permission with Dexter
        Dexter.withActivity(this)
                .withPermission(Manifest.permission.CALL_PHONE)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse response) {
                        startActivity(MainActivity.this);
                    }

                    private void startActivity(MainActivity mainActivity) {
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse response) {
                        Toast.makeText(MainActivity.this, "Please enable phone permission to be able to set calls", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                }).check();

        // Link Java with XML
        crdPolice = (CardView) findViewById(R.id.crd_police);
        crdAmbulance = (CardView) findViewById(R.id.crd_ambulance);
        crdFire = (CardView) findViewById(R.id.crd_fire);
        crdElectricity = (CardView) findViewById(R.id.crd_electricity);
        crdNatGas = (CardView) findViewById(R.id.crd_nat_gas);
        crdNTRA = (CardView) findViewById(R.id.crd_ntra);

        // Set setOnClickListener for Police card
        crdPolice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CallPolice();

            }
        });

        // Set setOnClickListener for Ambulance card
        crdAmbulance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CallAmbulance();
            }
        });

        // Set setOnClickListener for Fire Department card
        crdFire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CallFireDepartment();
            }
        });

        // Set setOnClickListener for Electricity card
        crdElectricity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CallElectricityEmergency();
            }
        });

        // Set setOnClickListener for Natural GAS Emergency card
        crdNatGas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CallNaturalGasEmergency();
            }
        });

        // Set setOnClickListener for NTRA card
        crdNTRA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CallNTRA();
            }
        });
    }

    // open Setting Dialog to alert user to enable permission from setting
    private void ShowSettingDialog() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Need Permission");
        builder.setMessage("Emergency Calls app need permission to connect with your phone dial");
        builder.setPositiveButton("GO TO SETTING", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                OpenSetting();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();
    }

    //Intent to App setting
    private void OpenSetting() {
        Intent settingIntent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", getPackageName(), null);
        settingIntent.setData(uri);
        startActivity(settingIntent);
    }

    private void CallPolice() {
        Dexter.withActivity(this)
                .withPermission(Manifest.permission.CALL_PHONE)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse response) {
                        OpenPoliceCall();
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse response) {
                        ShowSettingDialog();
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                }).check();
    }

    private void OpenPoliceCall() {
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
        Dexter.withActivity(this)
                .withPermission(Manifest.permission.CALL_PHONE)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse response) {
                        OpenAmbulanceCall();
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse response) {
                        ShowSettingDialog();
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                }).check();
    }

    private void OpenAmbulanceCall() {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel: 123"));
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

    public void CallFireDepartment() {
        Dexter.withActivity(this)
                .withPermission(Manifest.permission.CALL_PHONE)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse response) {
                        OpenFireDepartmentCall();
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse response) {
                        ShowSettingDialog();
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                }).check();
    }

    private void OpenFireDepartmentCall() {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel: 180"));
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

    public void CallElectricityEmergency() {
        Dexter.withActivity(this)
                .withPermission(Manifest.permission.CALL_PHONE)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse response) {
                        OpenElectricityEmergencyCall();
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse response) {
                        ShowSettingDialog();
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                }).check();
    }

    private void OpenElectricityEmergencyCall() {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel: 121"));
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

    public void CallNaturalGasEmergency() {
        Dexter.withActivity(this)
                .withPermission(Manifest.permission.CALL_PHONE)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse response) {
                        OpenNaturalGasEmergencyCall();
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse response) {
                        ShowSettingDialog();
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                }).check();
    }

    private void OpenNaturalGasEmergencyCall() {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel: 129"));
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

    public void CallNTRA() {
        Dexter.withActivity(this)
                .withPermission(Manifest.permission.CALL_PHONE)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse response) {
                        OpenNTRACall();
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse response) {
                        ShowSettingDialog();
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                }).check();
    }

    private void OpenNTRACall() {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel: 155"));
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
}