Clase 11 - “Desarrollador Java inicial”

Tipos de Archivo

Implemente un programa que lea una lista de ofertas, en un archivo CSV y escriba por la pantalla las
mismas en formato JSON (investigue como). El programa debe tomar como parámetros la ruta del
archivo y el tipo de salida (JSON).

Este es un ejemplo de oferta:
{
"producto":{
"nombre":"Azucar",
"peso": [12,"kg"],
"precio”: 700
},
"descuento":{
"tipo":"%",
"cantidad":0.3,
"tope":100
},
"fechaDesde": "2023-02-23",
"fechaHasta": "2023-03-23"
}


El CSV para este ejemplo podría ser:
Azucar, 12, kg, 700, %, 0.3, 100, 2023-02-23, 2023-03-23
