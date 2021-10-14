package pt.ulp.app1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    var numNotas: Int = 0
    var somaNotas: Int = 0
    private val TAG = MainActivity::class.java.simpleName

    // definição de callbacks de ciclo de vida da atividade
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i(TAG, "- onCreate()")
        super.onCreate(savedInstanceState)
        // Instanciar a parte gráfica com os elementos definidos
        setContentView(R.layout.activity_main)

        // Configurações adicionais
        // 1º alterar o conteúdo da etiqueta de saudação para "Olá [nome de aluno]"
        // pseudocódigo "R.id.txt_ola".text <- "ola ..."

        // 1ª opção
        findViewById<TextView>(R.id.txt_ola)
                .text = "Olá Pedro"

        // 2ª opção
        var saudacaoTextView:TextView = findViewById<TextView>(R.id.txt_ola)
        saudacaoTextView.text = getString(R.string.texto_saudacao_eng_inf)
        // getString(R.string.texto)
        //vai a strings.xml e devolve o valor do item texto
        // semelhante no que se usa no editor: @string/texto

        // 3ª opção
        var obj = findViewById<TextView>(R.id.txt_ola)
        obj.text = "Olá Pedro Manuel Maia Ferreira"

        // 2º definir comportamento

        findViewById<Button>(R.id.calcular_button)
            .setOnClickListener{ calcularResultado()}
    }

    override fun onStart() {
        Log.i(TAG, "- onStart()")
        super.onStart()
    }

    override fun onResume() {
        Log.i(TAG, "- onReseume()")
        super.onResume()
    }

    override fun onPause() {
        Log.i(TAG, "- onPause()")
        super.onPause()
    }

    override fun onStop() {
        Log.i(TAG, "- onStop()")
        super.onStop()
    }

    override fun onDestroy() {
        Log.i(TAG, "- onDestroy()")
        super.onDestroy()
    }

    // callback para guardar os dados entre etapas do ciclo de vida


    override fun onSaveInstanceState(outState: Bundle) {
        Log.i(TAG, "- onSaveInstanceState()")
        outState.putInt("chave_soma", somaNotas)
        outState.putInt("chave_soma", numNotas)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        Log.i(TAG, "- onRestoreInstanceState()")
        super.onRestoreInstanceState(savedInstanceState)
        //recuperação do valor das variaveis
        numNotas = savedInstanceState.getInt("chave_num")
        somaNotas = savedInstanceState.getInt("chave_soma")

    }

    fun calcularMedia(n: Int, s: Int) : Double{
        return (s*1.0)/n
    }

    fun calcularResultado(){
        // alterar resultado
        var resultadoTextView:TextView
            = findViewById(R.id.resultado_text_view)
        resultadoTextView.text = getString(R.string.calcular)

        // consultar valor na caixa de texto
        var valorEditText: EditText
                =  findViewById(R.id.valor_text_number)
        resultadoTextView.text = valorEditText.getText().toString()

        // converter valor da caixa de texto para inteiro
        val valorNota:Int = valorEditText.text.toString().toInt()

        // calcular o resultado
        numNotas++
        somaNotas += valorNota
        val media: Double = calcularMedia(numNotas, somaNotas)

        // atualizar a etiqueta N notas
        // 1 nota
        //resultadoTextView.text = numNotas + "nota: "
        //resultadoTextView.text = "$numNotas nota!"
        //resultadoTextView.text = getString(R.string.texto_num_notas, numNotas)
        resultadoTextView.text = resources.getQuantityString(R.plurals.texto_numero_notas, numNotas, numNotas)
        // quantidade para decidir e quantidade para substituir %1$d

        // atualizar a etiqueta da média
        var mediaTextView:TextView
                = findViewById(R.id.media_text_view)
        mediaTextView.text = getString(R.string.texto_resultado_media, media)

        // Apagar o conteudo da caixa de texto
        valorEditText.text.clear()






    // val count = getNumberOfSongsAvailable()

    }
}