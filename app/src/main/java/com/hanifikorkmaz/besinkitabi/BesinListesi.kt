package com.hanifikorkmaz.besinkitabi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.Gson
import com.hanifikorkmaz.besinkitabi.databinding.FragmentBesinListesiBinding
import com.hanifikorkmaz.besinkitabi.service.BesinAPI
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//https://raw.githubusercontent.com/atilsamancioglu/BTK20-JSONVeriSeti/refs/heads/master/besinler.json(İstek Atacağımız API)

class BesinListesi : Fragment() {

    private var _binding: FragmentBesinListesiBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBesinListesiBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BesinAPI::class.java)

        CoroutineScope(Dispatchers.IO).launch {

            val besinListesi= retrofit.getBesin()
            besinListesi.forEach {
                println(it.besinIsim)
            }
        }

        //Yenilenme Olduğunda Gerçekleşecek Eylem
        binding.BesinListesiSwipeRL.setOnRefreshListener {  }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}