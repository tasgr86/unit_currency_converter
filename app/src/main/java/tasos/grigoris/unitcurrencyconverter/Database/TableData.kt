//package tasos.grigoris.unitcurrencyconverter.Database
//
//import android.content.Context
//
//class TableData constructor(context: Context) : MyDB (context){
//
//    fun getLength(): TheLength {
//
//        lateinit var length : TheLength
//
//        val cursor = MyDB.database!!.rawQuery("SELECT * FROM length", null)
//
//        try {
//
//            if (cursor.count > 0) {
//
//                cursor.moveToFirst()
//
//                length = TheLength(cursor.getDouble(cursor.getColumnIndex("μm")),
//                    cursor.getDouble(cursor.getColumnIndex("mm")), cursor.getDouble(cursor.getColumnIndex("cm")),
//                    cursor.getDouble(cursor.getColumnIndex("dm")), cursor.getDouble(cursor.getColumnIndex("m")),
//                    cursor.getDouble(cursor.getColumnIndex("inch")), cursor.getDouble(cursor.getColumnIndex("ft")),
//                    cursor.getDouble(cursor.getColumnIndex("ft_in")), cursor.getDouble(cursor.getColumnIndex("yd")),
//                    cursor.getDouble(cursor.getColumnIndex("mile")), cursor.getDouble(cursor.getColumnIndex("km")),
//                    cursor.getDouble(cursor.getColumnIndex("ΝΜ")), cursor.getDouble(cursor.getColumnIndex("fathom")))
//
//            }
//
//        } catch (e: Exception) {
//            e.printStackTrace()
//
//        } finally {
//
//            cursor.close()
//
//        }
//
//        return length
//
//    }
//
//}