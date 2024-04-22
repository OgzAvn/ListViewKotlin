package com.oguz.landmarkbookkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.oguz.landmarkbookkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var landmarkList : ArrayList<LandMark>

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        landmarkList = ArrayList<LandMark>()

        //Data

        val pisa = LandMark("Pisa","Italy",R.drawable.pissa)
        val colosseum = LandMark("Colosseum","Italy",R.drawable.kolezyum)
        val eiffel = LandMark("Eiffel","France",R.drawable.eyfel)
        val londonbridge = LandMark("LondonBridge","UK",R.drawable.london)

        landmarkList.add(pisa)
        landmarkList.add(colosseum)
        landmarkList.add(eiffel)
        landmarkList.add(londonbridge)

        //Adapter : Layout & Data XML ile veri setini birleştirmek

        //Mapping

        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,landmarkList.map { landMark -> landMark.name  })

        binding.listView.adapter = adapter //Bağladım birbirine

        binding.listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val intent = Intent(this@MainActivity,DetailsActivity::class.java)
            intent.putExtra("landmark",landmarkList.get(position))
            startActivity(intent)
        }

    }
}