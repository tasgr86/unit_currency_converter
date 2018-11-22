package tasos.grigoris.unitcurrencyconverter

enum class MyEnums(var value : String, var fullName: Int) {

    // LENGTH
    M("1.0", R.string.meters),
    μM("1000000.0", R.string.μm),
    MM("1000.0", R.string.mm),
    CM("100.0", R.string.cm),
    DM("10.0", R.string.dm),
    INCH("39.3701", R.string.inch),
    FT("3.28084", R.string.feet),
    YD("1.09361", R.string.yards),
    MILE("0.000621371", R.string.mile),
    NAUT_MILE("0.000539957", R.string.nautical_mile),
    KM("0.001", R.string.kilometers),
    NM("0.00054", R.string.nm),
    FATHOM("0.546807", R.string.fathom),


    // WEIGHT
    KG("1.0", R.string.kilos),
    μG("1000000000.0", R.string.μg),
    MG("1000000.0", R.string.mg),
    G("1000.0", R.string.g),
    LB("2.204623", R.string.lb),          // pound
    OZ("35.273962", R.string.oz),         // ounce
    OZ_T("32.150747", R.string.oz_t),
    GRAIN("15432.3584", R.string.grain),
    TONNE("0.001", R.string.tonne),
    TON_UK("0.000984", R.string.ton_uk),
    TON_US("0.001102", R.string.ton_us),
    STONE_UK("0.157473", R.string.stone_uk),
    CWT("0.019684", R.string.cwt),          // A hundredweight - 100 pounds
    CARAT("5000.0", R.string.carat),


    // AREA
    M_SQUARE("1.0", R.string.square_meters),
    MM_SQUARE("1000000.0", R.string.square_mm),
    CM_SQUARE("10000.0", R.string.square_cm),
    DM_SQUARE("100.0", R.string.square_dm),
    IN_SQUARE("1550.0031", R.string.square_inch),
    FT_SQUARE("10.76391", R.string.square_feet),
    YD_SQUARE("1.19599", R.string.square_yd),
    A("0.01", R.string.a),
    HA("0.0001", R.string.ha),            // hectare equals to 100 ares
    KM_SQUARE("0.000001", R.string.square_km),
    ACRE("0.000247", R.string.acre),
    ML_SQUARE("0.0000003861", R.string.square_ml),

    // VOLUME
    LITRE("1.0", R.string.litre),
    ML("1000.0", R.string.ml),
    CL("100.0", R.string.cl),
    DL("10.0", R.string.dl),
    CUBIC_MM("1000000.0", R.string.cubic_mm),
    CUBIC_CM("1000.0", R.string.cubic_cm),
    CUBIC_DM("1.0", R.string.cubic_dm),
    CUBIC_M("0.001", R.string.cubic_m),
    CUBIC_IN("61.023744", R.string.cubic_in),
    CUBIC_FT("0.035315", R.string.cubic_feet),
    CUBIC_YD("0.001308", R.string.cubic_yards),
    GAL_UK("0.219969", R.string.gal_uk),
    GAL_US("0.264172", R.string.gal_us),
    BBL("0.00629", R.string.bbl),           // Oil barrels
    PT_UK("1.759754", R.string.pt_uk),          // Glass in which beer is served
    PT_US ("2.113376", R.string.pt_us),
    FL_OZ_US("33.814023", R.string.fl_oz_us),         // Fluid ounces
    TABLESPOON_UK("56.3121", R.string.tablespoon_uk),
    TEESPOON_UK("168.936", R.string.teaspoon_uk),

    //TEMPERATURE
    CELSIUS("1.0", R.string.celsius),
    FAHRENEIT("33.8", R.string.fahrenheit),
    KELVIN("274.14", R.string.kelvin),
    REAUMUR("0.8", R.string.réaumur),
    RANKINE("493.47", R.string.rankine),


    //POWER
    WATTS("1.0", R.string.watts),
    KWATTS("0.001", R.string.kwatts),
    MWATTS("0.000001", R.string.mwatts),
    BTU_HOUR("3.412141633", R.string.btu_hour),
    HP ("0.00134102", R.string.hp),
    PS ("0.00135962", R.string.ps),

    //SPEED
    KMH("1.0", R.string.kmh),
    MPH("0.621371", R.string.mph),
    M_S ("0.277778", R.string.m_s),
    FT_S("0.911344", R.string.ft_s),
    KNOT("0.539957", R.string.knot),
    MACH("0.000809848", R.string.mach),

    //TIME
    HOURS("1.0", R.string.hours),
    MINUTES("60.0", R.string.minutes),
    SECONDS("3600.0", R.string.seconds),
    MS("3600000.0", R.string.ms),
    DAY("0.0416667", R.string.days),
    WEEK("0.00595238", R.string.weeks),
    MONTH("0.00136986", R.string.months),
    YEAR("0.000114155", R.string.years),

    //DATA
    BIT("1.0", R.string.bit),
    BYTE("0.125", R.string._byte),
    KILOBIT( "0.001", R.string.kilobits),
    KILOBYTE("0.000125", R.string.kilobyte),
    MEGABIT("0.000001", R.string.megabit),
    MEGABYTE("0.000000125", R.string.megabyte),
    GIGABIT("0.000000001", R.string.gigabit),
    GIGABYTE("0.000000000125", R.string.gigabyte),
    TERABIT("0.000000000001", R.string.terabits),
    TERABYTE("0.000000000000125", R.string.terabyte),


    //ENERGY
    JOULE("1.0", R.string.joule),
    KILO_JOULE("0.001", R.string.kilojoules),
    CAL("0.239006", R.string.calorie),
    KCAL("0.000239006", R.string.kcalorie),
    KWH("0.000000277778", R.string.kwh),
    BTU("0.000947817", R.string.btu),
    TOE("0.0000000000238845896627496", R.string.btu_hour),

    //FUEL
    KM_L("1.0", R.string.km_l),
    MI_L ("0.621371", R.string.mi_l),
    KM_GAL("3.78541", R.string.km_gal),
    MI_GAL_US("2.352146", R.string.mi_gal_us),
    MI_GAL_UK("2.82481", R.string.mi_gal_uk)


}