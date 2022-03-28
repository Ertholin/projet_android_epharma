package com.example.epharma_inf1030_h22_g3.tab;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.epharma_inf1030_h22_g3.R;
import com.example.epharma_inf1030_h22_g3.databinding.FragmentItemBinding;
import com.example.epharma_inf1030_h22_g3.models.Medicament;
import com.example.epharma_inf1030_h22_g3.tab.placeholder.PlaceholderContent.PlaceholderItem;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlaceholderItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyMedicamentFragmentRecyclerViewAdapter extends RecyclerView.Adapter<MyMedicamentFragmentRecyclerViewAdapter.ViewHolder> {

    private Context context;
    private final DateTimeFormatter formatter;
    private final List<Medicament> medicaments;
    private Consumer<Medicament> itemClickCallBack;
    //private final List<PlaceholderItem> mValues;

    public MyMedicamentFragmentRecyclerViewAdapter(Context context) {
        this.context = context;
        medicaments = new ArrayList<>();
        formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);

        // return new ViewHolder(FragmentItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

        return new ViewHolder(DataBindingUtil.inflate(inflater,
                R.layout.fragment_item,
                parent,
                false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Medicament medicament = medicaments.get(position);
        holder.binder.name.setText(medicament.getDci());
        holder.binder.form.setText(medicament.getForm());
        holder.binder.dosage.setText(medicament.getDosage());
        holder.binder.status.setBackgroundResource(medicament.isNeedUpdate() ?
                R.drawable.circle_unsynched:
                R.drawable.circle_synched);
        holder.binder.date.setText(medicament.getUpdated() == null ? ""
                : medicament.getUpdated().format(formatter));
        holder.binder.getRoot().setOnClickListener(v->{
            if(itemClickCallBack != null)
                itemClickCallBack.accept(medicament);
        });
    }

    @Override
    public int getItemCount() {
        return medicaments.size();
    }


    public void addItems(Medicament medicament){
        int existedIndex = medicaments.indexOf(medicament);
        if(existedIndex >= 0){
            if(medicament.getUpdated().isAfter(medicaments.get(existedIndex).getUpdated())){
                medicaments.set(existedIndex, medicament);
                notifyItemInserted(existedIndex);
            }
        }else{
            medicaments.add(medicament);
            notifyItemInserted(medicaments.size() -1);
        }

    }

    public void setOnItemclick(Consumer<Medicament> callback) {
        this.itemClickCallBack = callback;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        FragmentItemBinding binder;
        public ViewHolder(FragmentItemBinding binder) {
            super(binder.getRoot());
            this.binder = binder;
        }
    }

//    public class ViewHolder extends RecyclerView.ViewHolder {
//        FragmentItemBinding binder;
//        public final TextView mIdView;
//        public final TextView mContentView;
//        public PlaceholderItem mItem;
//
//        public ViewHolder(FragmentItemBinding binder) {
//            super(binder.getRoot());
//            mIdView = binder.name;
//            mContentView = binder.form;
//        }
//        @Override
//        public String toString() {
//            return super.toString() + " '" + mContentView.getText() + "'";
//        }
//    }
}