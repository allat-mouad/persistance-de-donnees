package ma.enset.myapplicationn;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.io.FileOutputStream;
import java.io.PrintWriter;

import ma.enset.myapplicationn.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
        EditText txtNom=binding.editTextNom;
        EditText  txtPreNom=binding.editTextPrenom;
        EditText  txtAge=binding.editTextAge;
        binding.buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileOutputStream fileout = getActivity().openFileOutput("FragmentFile3.txt",Context.MODE_APPEND);
                    PrintWriter pw=new PrintWriter(fileout,true);
                    pw.println("Nom:"+txtNom.getText().toString()+"   Prenom:"+txtPreNom.getText().toString()
                    +"    Age:"+txtAge.getText().toString());

                    pw.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}