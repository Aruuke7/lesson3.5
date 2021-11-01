package Fragments;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.lesson35.R;
import com.example.lesson35.databinding.FragmentFirstBinding;



public class FirstFragment extends Fragment {
    private FragmentFirstBinding binding;
    private String text;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentFirstBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);




        binding.btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.editText.getText().toString().isEmpty()){
                    Toast.makeText(getContext(), "Enter text", Toast.LENGTH_SHORT).show();
                }else {
                    text = binding.editText.getText().toString();
                    SecondFragment fragment = new SecondFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("key1", text);
                    fragment.setArguments(bundle);
                    requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new SecondFragment(),"tag").commit();
                    Log.d("ololo", "onViewCreated: first передал "+text);
                }
            }
        });


    }
}