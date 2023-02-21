package com.akatsuki.jazireketab.ui.fragments.audio_details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import com.akatsuki.jazireketab.MainActivity
import com.akatsuki.jazireketab.R
import com.akatsuki.jazireketab.databinding.FragmentAudioDetailsBinding
import com.akatsuki.jazireketab.databinding.FragmentBookDetailsBinding
import com.akatsuki.jazireketab.ui.fragments.audio_details.adapters.BookListAudio_Adapter
import com.akatsuki.jazireketab.ui.fragments.audio_details.adapters.CoomentListAudio_Adapter
import com.akatsuki.jazireketab.ui.fragments.book_details.BookDetailsViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AudioDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AudioDetailsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    private var viewModel: AudioDetailsViewModel? = null


    private var _binding: FragmentAudioDetailsBinding? = null
    private val binding get() = _binding!!

    private lateinit var commentListAdapter: CoomentListAudio_Adapter
    private lateinit var booklistAdapter: BookListAudio_Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAudioDetailsBinding.inflate(inflater, container, false)
        val view = binding.root

        (activity as MainActivity).hideActionbar()
        (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true);
        (activity as MainActivity).supportActionBar?.setDisplayShowHomeEnabled(true);


        viewModel = ViewModelProvider(requireActivity())[AudioDetailsViewModel::class.java]

        commentListAdapter = CoomentListAudio_Adapter()
        booklistAdapter = BookListAudio_Adapter()

        binding.listFamilar.apply {
            adapter = booklistAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
        }

        binding.listComments.apply {
            adapter = booklistAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            setHasFixedSize(true)
        }
        viewModel!!.response.observe(requireActivity(), Observer {
            binding.bookTitle.text = it.title
            binding.aboutBook.originalText = it.about.toString()
            binding.bookAuthor.text = it.author.toString()
            binding.bookPrice.text = it.price.toString()
            binding.bookType.text = it.type
            binding.bookNashr.text = it.nashr
            binding.bookRealCat.text = it.realCat
            binding.bookCover.load(it.cover)

            commentListAdapter.items = it.listComments
            booklistAdapter.items = it.listBooks
            if (it.isBuyed){
                binding.canComment.visibility = View.VISIBLE
                binding.cantComment.visibility = View.GONE
            }else{
                binding.canComment.visibility = View.GONE
                binding.cantComment.visibility = View.VISIBLE
            }
        })

        return view.rootView
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AudioDetailsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AudioDetailsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}