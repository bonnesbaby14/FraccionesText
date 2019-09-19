/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fracciones;

/**
 *
 * @author Lenovo
 */
public class Operador {

    String operacion, texto;
    String[] fraccionesText;
    Fraccion resultado;
    Fraccion[] operandos;
    String[] datosM = {"", "mil", "dos mil", "tres mil", "cuatro mil", "cinco mil", "seis mil", "siete mil", "ocho mil", "nueve mil"};
    String[] datosC = {"", " ciento", " doscientos", " trescientos", " cuatrocientos", " quinientos", " seiscientos", " setecientos", " ochocientos", " novecientos"};
    String[] datosD = {" ", " dieci", " veinti", " trenta y ", " cuarenta y ", " cincuenta y ", " sesenta y ", " setenta y ", " ochenta y ", " noventa y "};
    String[] datosU = {"", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve"};

    public Operador(String texto) {
        this.texto = texto;

        separator();
        toFraccion();
        resolve();
        resultado();

    }

    /**
     *
     * @return el numero escrito por el usuaro como entero
     */
    private void toFraccion() {
        Fraccion[] fracciones = new Fraccion[2];
        for (int q = 0; q < 2; q++) {

            boolean numerador = false;
            int numero = 0;
            int denominador = 0;
            String[] datos = fraccionesText[q].split(" ");

            for (int x = datos.length - 1; x >= 0; x--) {

//            System.out.println(datos[x]);
                if (numerador) {
                    //numeradores
                    if (datos[x].equals("mil")) {
                        numero += 1000;
                    } else if (datos[x].equals("ciento")) {
                        numero += 100;
                    } else if (datos[x].equals("doscientos")) {
                        numero += 200;
                    } else if (datos[x].equals("trescientos")) {
                        numero += 300;
                    } else if (datos[x].equals("cuatrocientos")) {
                        numero += 400;
                    } else if (datos[x].equals("quinientos")) {
                        numero += 500;
                    } else if (datos[x].equals("seiscientos")) {
                        numero += 600;
                    } else if (datos[x].equals("setecientos")) {
                        numero += 700;
                    } else if (datos[x].equals("ochocientos")) {
                        numero += 800;
                    } else if (datos[x].equals("novecientos")) {
                        numero += 900;
                    } else if (datos[x].equals("diez")) {
                        numero += 10;
                    } else if (datos[x].equals("veinte")) {
                        numero += 20;
                    } else if (datos[x].equals("treinta")) {
                        numero += 30;
                    } else if (datos[x].equals("cuarenta")) {
                        numero += 40;
                    } else if (datos[x].equals("cincuenta")) {
                        numero += 50;
                    } else if (datos[x].equals("sesenta")) {
                        numero += 60;
                    } else if (datos[x].equals("setenta")) {
                        numero += 70;
                    } else if (datos[x].equals("ochenta")) {
                        numero += 80;
                    } else if (datos[x].equals("noventa")) {
                        numero += 90;
                    } else if (datos[x].length() > 4) {
                        //aqui emprezo
                        if (datos[x].substring(0, 5).equals("dieci")) {

                            switch (datos[x].substring(5, datos[x].length())) {
                                case "seis":
                                    numero += 16;
                                    break;
                                case "siete":
                                    numero += 17;
                                    break;
                                case "ocho":
                                    numero += 18;
                                    break;
                                case "nueve":
                                    numero += 19;
                                    break;
                                default:
                                    break;
                            }

                        }
                        //aqui termino
                    } else if (datos[x].contains("once")) {
                        numero += 11;
                    } else if (datos[x].contains("doce")) {
                        numero += 12;
                    } else if (datos[x].contains("trece")) {
                        numero += 13;
                    } else if (datos[x].contains("catorce")) {
                        numero += 14;
                    } else if (datos[x].contains("quince")) {
                        numero += 15;
                    }

                    if (datos[x].length() > 5) {
                        //aqui emprezo
                        if (datos[x].substring(0, 6).equals("veinti")) {

                            switch (datos[x].substring(6, datos[x].length())) {
                                case "uno":
                                    numero += 21;
                                    break;
                                case "dos":
                                    numero += 22;
                                    break;
                                case "tres":
                                    numero += 23;
                                    break;
                                case "cuatro":
                                    numero += 24;
                                    break;
                                case "cinco":
                                    numero += 25;
                                    break;
                                case "seis":
                                    numero += 26;
                                    break;
                                case "siete":
                                    numero += 27;
                                    break;
                                case "ocho":
                                    numero += 28;
                                    break;
                                case "nueve":
                                    numero += 29;
                                    break;
                                default:
                                    break;
                            }

                        }
                        //aqui termino
                    }

                    switch (datos[x]) {
                        case "un":
                            numero += 1;
                            break;
                        case "uno":
                            numero += 1;
                            break;
                        case "dos":
                            numero += 2;
                            break;
                        case "tres":
                            numero += 3;
                            break;
                        case "cuatro":
                            numero += 4;
                            break;
                        case "cinco":
                            numero += 5;
                            break;
                        case "seis":
                            numero += 6;
                            break;
                        case "siete":
                            numero += 7;
                            break;
                        case "ocho":
                            numero += 8;
                            break;
                        case "nueve":
                            numero += 9;
                            break;
                        default:
                            break;
                    }

                } else {

                    //para denominadores
                    if (datos[x].contains("avos") || datos[x].contains("avo")) {

                        if (datos[x].contains("mil")) {

                            if (datos[x].length() - datos[x].indexOf("mil") > 7) {
                                if (datos[x].substring(datos[x].indexOf("mil"), datos[x].indexOf("mil") + 6).equals("milesima")) {

                                } else {
                                    denominador += 1000;
                                }
                            } else {
                                denominador += 1000;
                            }

                        }

                        if (datos[x].contains("once")) {
                            denominador += 11;
                        }
                        if (datos[x].contains("doce")) {
                            denominador += 12;
                        }
                        if (datos[x].contains("trece")) {
                            denominador += 13;
                        }
                        if (datos[x].contains("catorce")) {
                            denominador += 14;
                        }
                        if (datos[x].contains("quince")) {
                            denominador += 15;
                        }
                        if (datos[x].contains("un")) {
                            denominador += 1;
                        }

                        if (datos[x].contains("dos")) {

                            if (datos[x].length() - datos[x].indexOf("dos") > 7) {
                                if (datos[x].substring(datos[x].indexOf("dos"), datos[x].indexOf("dos") + 9).equals("dosciento")) {

                                } else {
                                    denominador += 2;
                                }
                            } else {
                                denominador += 2;
                            }

                        }
                        if (datos[x].contains("tres")) {
                            if (datos[x].length() - datos[x].indexOf("tres") > 8) {
                                if (datos[x].substring(datos[x].indexOf("tres"), datos[x].indexOf("tres") + 10).equals("tresciento")) {

                                } else {
                                    denominador += 3;
                                }
                            } else {
                                denominador += 3;
                            }
                        }
                        if (datos[x].contains("cuatro")) {
                            if (datos[x].length() - datos[x].indexOf("cuatro") > 11) {
                                if (datos[x].substring(datos[x].indexOf("cuatro"), datos[x].indexOf("cuatro") + 12).equals("cuatrociento")) {

                                } else {
                                    denominador += 4;
                                }
                            } else {
                                denominador += 4;
                            }
                        }
                        if (datos[x].contains("cinco")) {
                            denominador += 5;
                        }
                        if (datos[x].contains("seis")) {
                            if (datos[x].length() - datos[x].indexOf("seis") > 10) {
                                if (datos[x].substring(datos[x].indexOf("seis"), datos[x].indexOf("seis") + 10).equals("seisciento")) {

                                } else {
                                    denominador += 6;
                                }
                            } else {
                                denominador += 6;
                            }
                        }
                        if (datos[x].contains("siete")) {
                            denominador += 7;
                        }
                        if (datos[x].contains("ocho")) {
                            if (datos[x].length() - datos[x].indexOf("ocho") > 9) {

                                if (datos[x].substring(datos[x].indexOf("ocho"), datos[x].indexOf("ocho") + 10).equals("ochociento")) {

                                } else {
                                    denominador += 8;
                                }
                            } else {
                                denominador += 8;
                            }
                        }
                        if (datos[x].contains("nueve")) {
                            denominador += 9;
                        }
                        if (datos[x].contains("dieci")) {
                            denominador += 10;
                        }

                        if (datos[x].contains("veinti")) {
                            denominador += 20;
                        }

                        if (datos[x].contains("treintai")) {
                            denominador += 30;
                        }
                        if (datos[x].contains("cuarentai")) {
                            denominador += 40;
                        }
                        if (datos[x].contains("cincuentai")) {
                            denominador += 50;
                        }
                        if (datos[x].contains("sesentai")) {
                            denominador += 60;
                        }
                        if (datos[x].contains("setentai")) {
                            denominador += 70;
                        }
                        if (datos[x].contains("ochentai")) {
                            denominador += 80;
                        }
                        if (datos[x].contains("noventai")) {
                            denominador += 90;
                        }
                        if (datos[x].contains("ciento")) {
                            if (datos[x].contains("dosciento")) {
                                if (datos[x].contains("doscientosdos")) {
                                    denominador += 202;
                                } else {
                                    denominador += 200;
                                }
                            } else if (datos[x].contains("tresciento")) {
                                if (datos[x].contains("trescientostres")) {
                                    denominador += 303;
                                } else {
                                    denominador += 300;
                                }
                            } else if (datos[x].contains("cuatrociento")) {
                                if (datos[x].contains("cuatrocientoscuatro")) {
                                    denominador += 404;
                                } else {
                                    denominador += 400;
                                }
                            } else if (datos[x].contains("quiniento")) {
                                denominador += 500;
                            } else if (datos[x].contains("seisciento")) {
                                if (datos[x].contains("seiscientosseis")) {
                                    denominador += 606;
                                } else {
                                    denominador += 600;
                                }
                            } else if (datos[x].contains("seteciento")) {
                                denominador += 700;
                            } else if (datos[x].contains("ochociento")) {
                                if (datos[x].contains("ochocientosocho")) {
                                    denominador += 808;
                                } else {
                                    denominador += 800;
                                }
                            } else if (datos[x].contains("noveciento")) {
                                denominador += 900;
                            } else {
                                denominador += 100;
                            }

                        }
                    }

                    if (datos[x].equals("entero") || datos[x].equals("enteros")) {
                        denominador += 1;
                    }
                    if (datos[x].equals("medio") || datos[x].equals("medios")) {
                        denominador += 2;
                    }
                    if (datos[x].equals("tercio") || datos[x].equals("tercios")) {
                        denominador += 3;
                    }
                    if (datos[x].equals("cuarto") || datos[x].equals("cuartos")) {
                        denominador += 4;
                    }
                    if (datos[x].equals("quinto") || datos[x].equals("quintos")) {
                        denominador += 5;
                    }
                    if (datos[x].equals("sexto") || datos[x].equals("sextos")) {
                        denominador += 6;
                    }
                    if (datos[x].equals("septimo") || datos[x].equals("septimos")) {
                        denominador += 7;
                    }
                    if (datos[x].equals("octavo") || datos[x].equals("octavos")) {
                        denominador += 8;
                    }
                    if (datos[x].equals("noveno") || datos[x].equals("novenos")) {
                        denominador += 9;
                    }
                    if (datos[x].equals("decima") || datos[x].equals("decimas") || datos[x].equals("decimos") || datos[x].equals("decimo")) {
                        denominador += 10;
                    }
                    if (datos[x].equals("centesima") || datos[x].equals("centesimas") || datos[x].equals("centesimos") || datos[x].equals("centesimos")) {
                        denominador += 100;
                    }
                    if (datos[x].equals("milesima") || datos[x].equals("milesimas") || datos[x].equals("milesimos") || datos[x].equals("milesimo")) {
                        denominador += 1000;
                    }

                    numerador = true;

                }
//aqui a la asignacion de arregglo
            }
            fracciones[q] = new Fraccion(numero, denominador);
            numero = 0;
            denominador = 0;
            numerador = false;
            //fin del for para sacar las dos fracciones
        }

        operandos = fracciones;
    }

    private void separator() {
        fraccionesText = new String[2];
        if (texto.contains("mas")) {
            fraccionesText[0] = texto.substring(0, texto.indexOf("mas") - 1);

            fraccionesText[1] = texto.substring(texto.indexOf("mas") + 4, texto.length());
            operacion = "suma";
        }
        if (texto.contains("menos")) {
            fraccionesText[0] = texto.substring(0, texto.indexOf("menos") - 1);

            fraccionesText[1] = texto.substring(texto.indexOf("menos") + 6, texto.length());
            operacion = "resta";
        }
        if (texto.contains("por")) {
            fraccionesText[0] = texto.substring(0, texto.indexOf("por") - 1);

            fraccionesText[1] = texto.substring(texto.indexOf("por") + 4, texto.length());
            operacion = "multiplicacion";
        }
        if (texto.contains("entre")) {
            fraccionesText[0] = texto.substring(0, texto.indexOf("entre") - 1);

            fraccionesText[1] = texto.substring(texto.indexOf("entre") + 6, texto.length());
            operacion = "division";
        }

    }

    private void resolve() {
        int[] c = {2, 3, 5, 7, 11, 13};

        if (operacion.equals("suma")) {

            resultado = new Fraccion((operandos[0].numerador * operandos[1].denominador) + (operandos[1].numerador * operandos[0].denominador), operandos[0].denominador * operandos[1].denominador);
            for (int i = 0; i < 6; i++) {
                while ((resultado.numerador % c[i] == 0) && (resultado.denominador % c[i] == 0)) {
                    resultado.numerador = resultado.numerador / c[i];
                    resultado.denominador = resultado.denominador / c[i];

                }
            }

        } else if (operacion.equals("resta")) {
            resultado = new Fraccion((operandos[0].numerador * operandos[1].denominador) - (operandos[1].numerador * operandos[0].denominador), operandos[0].denominador * operandos[1].denominador);
            for (int i = 0; i < 6; i++) {
                while ((resultado.numerador % c[i] == 0) && (resultado.denominador % c[i] == 0)) {
                    resultado.numerador = resultado.numerador / c[i];
                    resultado.denominador = resultado.denominador / c[i];

                }
            }
        } else if (operacion.equals("multiplicacion")) {
            resultado = new Fraccion(operandos[0].numerador * operandos[1].numerador, operandos[0].denominador * operandos[1].denominador);
            for (int i = 0; i < 6; i++) {
                while ((resultado.numerador % c[i] == 0) && (resultado.denominador % c[i] == 0)) {
                    resultado.numerador = resultado.numerador / c[i];
                    resultado.denominador = resultado.denominador / c[i];

                }
            }
        } else if (operacion.equals("division")) {
            resultado = new Fraccion(operandos[0].numerador * operandos[1].denominador, operandos[1].numerador * operandos[0].denominador);
            for (int i = 0; i < 6; i++) {
                while ((resultado.numerador % c[i] == 0) && (resultado.denominador % c[i] == 0)) {
                    resultado.numerador = resultado.numerador / c[i];
                    resultado.denominador = resultado.denominador / c[i];

                }
            }
        }

    }

    private String toLetra(int copia) {
        //proceso uno
        int enteros = 0, decimas = 0, centesimas = 0, milesimas = 0;
        boolean flat = false;
        String resultadoS = "";

        milesimas = copia / 1000;
        copia = copia - (milesimas * 1000);
        centesimas = copia / 100;
        copia = copia - (centesimas * 100);
        decimas = copia / 10;
        copia = copia - (decimas * 10);
        enteros = copia;

        for (int x = 0; x < 10; x++) {
            if (milesimas == x) {
                resultadoS += datosM[x];
            }

        }
        for (int x = 0; x < 10; x++) {
            if (centesimas == x) {
                resultadoS += datosC[x];
            }

        }
        for (int x = 0; x < 10; x++) {
            if (decimas == x) {
                if (x == 1) {
                    if (enteros == 1) {
                        resultadoS += " once";
                        flat = true;
                    } else if (enteros == 2) {
                        resultadoS += " doce";
                        flat = true;
                    } else if (enteros == 3) {
                        resultadoS += " trece";
                        flat = true;
                    } else if (enteros == 4) {
                        resultadoS += " catorce";
                        flat = true;
                    } else if (enteros == 5) {
                        resultadoS += " quince";
                        flat = true;

                    } else if (enteros == 0) {
                        resultadoS += " diez";
                        flat = true;
                    } else {
                        resultadoS += datosD[x];
                    }

                } else if (x == 2) {

                    if (enteros == 0) {
                        resultadoS += " veinte";
                        flat = true;
                    } else {
                        resultadoS += datosD[x];
                    }

                } else if (x == 3) {

                    if (enteros == 0) {
                        resultadoS += " treinta";
                        flat = true;
                    } else {
                        resultadoS += datosD[x];
                    }

                } else if (x == 4) {

                    if (enteros == 0) {
                        resultadoS += " cuarenta";
                        flat = true;
                    } else {
                        resultadoS += datosD[x];
                    }

                } else if (x == 5) {

                    if (enteros == 0) {
                        resultadoS += " cincuenta";
                        flat = true;
                    } else {
                        resultadoS += datosD[x];
                    }

                } else if (x == 6) {

                    if (enteros == 0) {
                        resultadoS += " sesenta";
                        flat = true;
                    } else {
                        resultadoS += datosD[x];
                    }

                } else if (x == 7) {

                    if (enteros == 0) {
                        resultadoS += " setenta";
                        flat = true;
                    } else {
                        resultadoS += datosD[x];
                    }

                } else if (x == 8) {

                    if (enteros == 0) {
                        resultadoS += " ochenta";
                        flat = true;
                    } else {
                        resultadoS += datosD[x];
                    }

                } else if (x == 9) {

                    if (enteros == 0) {
                        resultadoS += " noventa";
                        flat = true;
                    } else {
                        resultadoS += datosD[x];
                    }
                }
            }

        }
        if (!flat) {

            for (int x = 0; x < 10; x++) {
                if (enteros == x) {
                    resultadoS += datosU[x];
                }

            }

        }

        return resultadoS;

    }

    private void resultado() {

        String resultadoSN = "", resultadoSD = "";
        //numerador
        resultadoSN = toLetra(resultado.numerador);

        if (resultado.denominador == 1) {
            resultadoSD += " enteros";
        } else if (resultado.denominador == 2) {
            resultadoSD += " medios";
        } else if (resultado.denominador == 3) {
            resultadoSD += " tercios";
        } else if (resultado.denominador == 4) {
            resultadoSD += " cuartos";
        } else if (resultado.denominador == 5) {
            resultadoSD += " quintos";
        } else if (resultado.denominador == 6) {
            resultadoSD += " sextos";
        } else if (resultado.denominador == 7) {
            resultadoSD += " septimos";
        } else if (resultado.denominador == 8) {
            resultadoSD += " octavos";
        } else if (resultado.denominador == 9) {
            resultadoSD += " novenos";
        } else if (resultado.denominador == 10) {
            resultadoSD += " decimos";
        } else if (resultado.denominador == 100) {
            resultadoSD += " centesimos";
        } else if (resultado.denominador == 1000) {
            resultadoSD += " milesimos";
        } else {
            resultadoSD += toLetra(resultado.denominador);
            String[] a = resultadoSD.split(" ");
            resultadoSD = "";
            for (int i = 0; i < a.length; i++) {
                if (a[i].equals("y")) {
                    a[i] = "i";
                }
                resultadoSD += a[i];
            }
            resultadoSD += "avos";
        }
        
        String simbolo="";
        if(operacion.equals("suma")){
        simbolo="+";
        }else if(operacion.equals("resta")){
        simbolo="-";
        }else if(operacion.equals("multiplicacion")){
        simbolo="x";
        }else if(operacion.equals("division")){
        simbolo="/";
        }else
            System.out.println("");
        System.out.println(" " + operandos[0].numerador + "   " + operandos[1].numerador + "      " + resultado.numerador);
        System.out.println("-- " +simbolo+"  --  = --");
        System.out.println(" " + operandos[0].denominador + "   " + operandos[1].denominador + "      " + resultado.denominador);

        System.out.println(resultadoSN + " " + resultadoSD);
    }

}
