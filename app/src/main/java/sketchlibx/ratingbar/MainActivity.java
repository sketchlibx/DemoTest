package sketchlibx.ratingbar;

import android.Manifest;
import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.ClipData;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.airbnb.lottie.*;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;
import sketchlibx.ratingbar.databinding.*;

public class MainActivity extends AppCompatActivity {
	
	public final int REQ_CD_HH = 101;
	
	static {
		System.loadLibrary("native-lib");
	}
	
	public native int test();
	private MainBinding binding;
	
	private Intent hh = new Intent(Intent.ACTION_GET_CONTENT);
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		binding = MainBinding.inflate(getLayoutInflater());
		setContentView(binding.getRoot());
		initialize(_savedInstanceState);
		
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, 1000);
		} else {
			initializeLogic();
		}
	}
	
	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
	}
	
	private void initialize(Bundle _savedInstanceState) {
		hh.setType("*/*");
		hh.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		
		binding.button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SketchwareUtil.showMessage(getApplicationContext(), String.valueOf(test()));
			}
		});
	}
	
	private void initializeLogic() {
		String[] lottieFiles = {
			"1star.json",
			"2star.json",
			"3star.json",
			"4star.json",
			"5star.json"
		};
		
		binding.lottieRatingBar.setLottieAnimations(lottieFiles);
	}
	
	public void _bh() {
		
	}
	
}