package com.fauzan.tokoku.fargment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.fauzan.tokoku.R
import com.fauzan.tokoku.adapter.AdapterProduk
import com.fauzan.tokoku.model.Produk
import com.inyongtisto.tutorial.adapter.AdapterSlider

class HomeFragment : Fragment() {
    //pemanggilan valiaber slider
    lateinit var  vpslider: ViewPager
    //deklarasi recycler view
    lateinit var rvProduk: RecyclerView
    lateinit var rvPopuler: RecyclerView
    lateinit var rvTerbaru: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

        vpslider = view.findViewById(R.id.vp_slider)
        rvProduk = view.findViewById(R.id.rv_produk)
        rvPopuler = view.findViewById(R.id.rv_populer)
        rvTerbaru = view.findViewById(R.id.rv_terbaru)

        //pnmbahan gmbr slider
        val arrSlider = ArrayList<Int>()
        arrSlider.add(R.drawable.slider1)
        arrSlider.add(R.drawable.slider2)
        arrSlider.add(R.drawable.slider3)

        val adapterSlider= AdapterSlider(arrSlider, activity)
        vpslider.adapter = adapterSlider

        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL

        val layoutManager2 = LinearLayoutManager(activity)
        layoutManager2.orientation = LinearLayoutManager.HORIZONTAL

        val layoutManager3 = LinearLayoutManager(activity)
        layoutManager3.orientation = LinearLayoutManager.HORIZONTAL
        //panggil adapter
        rvProduk.adapter = AdapterProduk(arrProduk)
        rvProduk.layoutManager = layoutManager

        rvPopuler.adapter = AdapterProduk(arrPopuler)
        rvPopuler.layoutManager = layoutManager2

        rvTerbaru.adapter = AdapterProduk(arrTerbaru)
        rvTerbaru.layoutManager = layoutManager3

        return view
    }
    val arrProduk: ArrayList<Produk>get() {
        val arr = ArrayList<Produk>()
        val p1 = Produk()
        p1.nama = "Kain Batik Motif Daun"
        p1.harga = "Rp. 40.000"
        p1.gambar = R.drawable.batik1

        val p2 = Produk()
        p2.nama = "Kain Batik Motif Sejajar"
        p2.harga = "Rp. 40.000"
        p2.gambar = R.drawable.batik2

        val p3 = Produk()
        p3.nama = "Kain Batik Motif Lukir"
        p3.harga = "Rp. 50.000"
        p3.gambar = R.drawable.batik3

        val p4 = Produk()
        p4.nama = "Kain Batik Motif Kotak"
        p4.harga = "Rp. 55.000"
        p4.gambar = R.drawable.batik4

        val p5 = Produk()
        p5.nama = "Kain Batik Motif Kembar"
        p5.harga = "Rp. 60.000"
        p5.gambar = R.drawable.batik5

        arr.add(p1)
        arr.add(p2)
        arr.add(p3)
        arr.add(p4)
        arr.add(p5)


        return arr
    }
    val arrPopuler: ArrayList<Produk>get() {
        val arr = ArrayList<Produk>()
        val p1 = Produk()
        p1.nama = "Baju Batik Couple Motif Sunn"
        p1.harga = "Rp. 190.000"
        p1.gambar = R.drawable.batik21

        val p2 = Produk()
        p2.nama = "Baju Batik Couple Motif Jawa"
        p2.harga = "Rp. 180.000"
        p2.gambar = R.drawable.batik22

        val p3 = Produk()
        p3.nama = "Baju Batik Couple Motif Gading"
        p3.harga = "Rp. 170.000"
        p3.gambar = R.drawable.batik24

        val p4 = Produk()
        p4.nama = "Baju Batik Couple Motif Merona"
        p4.harga = "Rp. 165.000"
        p4.gambar = R.drawable.batik25

        arr.add(p1)
        arr.add(p2)
        arr.add(p3)
        arr.add(p4)

        return arr
    }
    val arrTerbaru: ArrayList<Produk>get() {
        val arr = ArrayList<Produk>()
        val p1 = Produk()
        p1.nama = "Tas Batik Selempang Untuk Wanita"
        p1.harga = "Rp. 90.000"
        p1.gambar = R.drawable.batik31

        val p2 = Produk()
        p2.nama = "Tas Rajutan Batik"
        p2.harga = "Rp. 80.000"
        p2.gambar = R.drawable.batik32

        val p3 = Produk()
        p3.nama = "Sepatu Sekolah Motif Batik"
        p3.harga = "Rp. 135.000"
        p3.gambar = R.drawable.batik33

        val p4 = Produk()
        p4.nama = "Tas Batik Ransel Kecil Untuk Wanita"
        p4.harga = "Rp. 70.000"
        p4.gambar = R.drawable.batik34

        val p5 = Produk()
        p5.nama = "Mukenah Batik Motif Bunga"
        p5.harga = "Rp. 155.000"
        p5.gambar = R.drawable.batik35

        arr.add(p1)
        arr.add(p2)
        arr.add(p3)
        arr.add(p4)
        arr.add(p5)


        return arr
    }

}