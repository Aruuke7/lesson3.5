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
import com.example.lesson35.databinding.FragmentSecondBinding;


public class SecondFragment extends Fragment {
    private String string;
    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSecondBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            string = getArguments().getString("key1","");
            binding.textView.setText(string);
            Log.d("ololo", "onClick: second получил " + string);
        }else {
            Toast.makeText(this.getContext(), "getArguments is null", Toast.LENGTH_SHORT).show();
        }

        binding.btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThirdFragment fragment = new ThirdFragment();
                Bundle bundle1 = new Bundle();
                bundle1.putString("key2",string);
                Log.d("ololo", "onViewCreated: отправил "+string);
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new ThirdFragment(),"tag").commit();
                fragment.setArguments(bundle1);

            }
        });
    }
}