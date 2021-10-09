package com.example.amaal_almutairi1

import android.content.DialogInterface

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var clroot: ConstraintLayout
    lateinit var submitb: Button
    lateinit var solutionT: EditText

    lateinit var scoreTv: TextView
    lateinit var High_recy: RecyclerView

    lateinit var opt: TextView
    lateinit var equations: ArrayList<String>
         lateinit var share:SharedPreferences

    var score = 0
    var high_score = 0
    var FirstN = Random.nextInt(100)
    var SecondN = Random.nextInt(100)
    var op = "+"


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        submitb = findViewById(R.id.b1)
        solutionT = findViewById(R.id.sol)
        scoreTv = findViewById(R.id.txtv)
        High_recy = findViewById(R.id.Rscor)
        opt = findViewById(R.id.opTv)
        clroot = findViewById(R.id.cal)
        equations = ArrayList()
        alertdailog()
        scoreTv.text="High Score:$high_score \n Score:$score"

        High_recy.adapter = myadapter(equations)
        High_recy.layoutManager = LinearLayoutManager(this)

        share = this.getSharedPreferences(
            getString(R.string.preference_file_key), MODE_PRIVATE
        )



        opt.text="${FirstN } +  ${SecondN}"




            submitb.setOnClickListener {

                val currectAns = solutionT.text.toString()
                if(currectAns=="${FirstN + SecondN}"){
                    equations.add("$FirstN + $SecondN = $currectAns")
                    score++
                    save()
                }else if(currectAns=="{$FirstN - $SecondN}") {
                    equations.add("$FirstN - $SecondN = $currectAns")
                    score++


                        loseDialog()
                    Subtraction()


                    }


            scoreTv.text="High Score:$high_score \n Score:$score"

            High_recy.adapter?.notifyDataSetChanged()
            High_recy.scrollToPosition(equations.size - 1)
            High_recy.layoutManager = LinearLayoutManager(this)
            solutionT.clearFocus()
            solutionT.text.clear()

             FirstN = Random.nextInt(100)
            SecondN = Random.nextInt(100)
            opt.text="${FirstN } +  ${SecondN}"
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
       menuInflater.inflate(R.menu.list_menu,menu)
        return true
    }

    private fun loseDialog() {

        save()

        var msg = AlertDialog.Builder(this)

        msg.setTitle("New Round ")
        msg.setMessage("you want to play again ? ")
        msg.setPositiveButton("yes",DialogInterface.OnClickListener{
                _, _ -> this.recreate()
        })
        msg.setNegativeButton("No",DialogInterface.OnClickListener { dialog, _ -> dialog.dismiss() })

        //


        msg.show()
    }


    fun alertdailog() {
        var msg = AlertDialog.Builder(this)

        msg.setTitle("Math Study App ")
        msg.setMessage("Welcome to the math study app ! \n how many equations you solve?")
        msg.setPositiveButton("OK",DialogInterface.OnClickListener{
            dialog, id -> dialog.cancel()
        })

        // this.recreate()


        msg.show()

    }


    private fun save() {
        if (score > high_score) {
            with(share.edit()) {
                putInt("high_score", high_score)
                apply()

            }
        }
    }
    fun Addition(item: android.view.MenuItem) {
        equations.add("$FirstN + $SecondN =")
        var FirstN = Random.nextInt(100)
        var SecondN = Random.nextInt(100)
        High_recy.adapter?.notifyDataSetChanged()


    }
    fun Subtraction() {
      opt.text=("$FirstN - $SecondN =")
        var FirstN = Random.nextInt(100)
        var SecondN = Random.nextInt(100)
    }




}
