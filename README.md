# Talleer9_POO
CASO DE ESTUDIO 1:

El comité organizador del Festival Internacional de Artes Vivas Loja (FIAVL 2025), necesita un sistema que permita gestionar las presentaciones artísticas, donde cada presentación posee información base como su título, duración en minutos y un costo base (este último costo base) es calculado así: costo base es igual al, límite de personas de aforo permitido para el evento o presentación dividido entre el total del presupuesto asignado para los recursos técnicos, es decir: el total de los gastos para el sonido más la iluminación y más la escenografía.

Dependiendo de la naturaleza de la presentación (por ejemplo, música o teatro), se aplican procesos específicos para calcular el costo final. Donde: para las presentaciones musicales, el costo final es igual al costo base más su duración por 0.08, y, más el Aforo multiplicado por el índice de límites de aforo, en este último caso, el índice de límite de aforo será de 0.05 si el aforo permitido es de al menos 500 personas, caso contrario, este índice de límite de aforo será de 0.01. Por otro lado, para las presentaciones teatrales, se tiene que el costo final es igual al costo base por 1.1 y más la duración por 0.05.

Así, se aclara que, el sistema debe considerar los detalles presupuestarios para los recursos técnicos como: sonido, iluminación y escenario, cuyos costos adicionales deben sumarse al cálculo presupuestal de cada presentación. Estos recursos son gestionados de forma independiente pero asociados a cada presentación. Se sugiere bajo acoplamiento de entidades, para que a futuro se pueda implementar otros tipos de gastos presupuestales detallados (desglosados) independientes a las presentaciones. El sistema debe manejar dinámicamente todas las presentaciones y generar un reporte con el detalle de costos y recursos utilizados, así como las ganancias percibidas de cada presentación.

Resumen de los requerimientos funcionales:

Diseñar una solución que contenga información básica como título de la presentación, su duración y costo base; ello compartido para los distintos tipos de presentaciones. Nota: a futuro se podría requerir integrar diversos tipos de presentaciones adicionales, por lo que su arquitectura debe garantizar el acoplamiento (mantenibilidad).
Para el prototipo/demo del aplicativo inicial, implementar al menos los dos tipos de presentaciones (musicales y teatrales) con cálculos específicos de sus costos base, finales.
Establecer y relacionar la entidad que defina y gestione los recursos técnicos (sonido, iluminación y escenario) y que sea utilizada por las presentaciones para complementar su cálculo presupuestal de costos, garantizando el bajo acoplamiento.
Utilizar las colecciones dinámicas necesarias para registrar todas las presentaciones y sus recursos asociados.
Generar un reporte final que detalle las presentaciones, costos finales y sus presupuestos para los recursos técnicos utilizados en cada caso.
Para la solución del caso de estudio, se requiere:

Modelado de la solución UML, aprovechando al máximo las ventajas de la Abstracción, Encapsulamiento, Herencia y Polimorfismo, de la POO.
Implementación del modelado UML en el lenguaje de alto nivel orientado a objetos Java. Se debe agregar la clase de prueba/ejecutor que demuestre las funcionalidades de su solución.
Visualización clara y ordenada de los resultados generados en una eventual ejecución de su solución (prueba de escritorio).
CASO DE ESTUDIO 2:

En la UTPL se articulan algunos proyectos de innovación y de vinculación con la sociedad a través de financiamientos externos o con alianzas interinstitucionales. Precisamente en este 2025 KRADAC, UTPL y CEDIA, desean impulsar algunos proyectos de movilidad humana, de los cuales 2-3 ya están desarrollados y son de éxito en Loja, el País y extranjero, ejemplo: Clipp, Ktaxi, Situ, etc.

Como estudiante de nuestra UTPL, se le solicita modelar el diseño jerárquico de clases para un sistema que integre todas las opciones de movilidad existentes y las nuevas que están en desarrollo. Luego implementar este modelo en java, probando y mostrando su funcionalidad. Los lineamientos para el desarrollo del demo demostrativo son:

En la aplicación Clipp se cuenta ya con las siguientes opciones de movilidad basada en un Sistema de Posicionamiento Globa (GPS) y con distintos métodos de pago:
Ktaxi: que es una aplicación que permite solicitar la unidad de taxi más cercana posible y disponible. Su pago se realiza vía taxímetro propio del vehículo y/o con el taxímetro digital de la app móvil, calculando la longitud recorrida, el tiempo transcurrido y la taza por Km.
Situ: Una app que cuenta con los datos de las rutas urbanas y rurales de recorridos de buses locales. Esta app tiene digitalizada la tarjeta física, la que sirve para el pago del pasaje de $0.30 independientemente la ruta o distancia recorrida. Aquí si se aplica pago del 50% del pasaje para estudiantes, personas con capacidades especiales, entre otras.
Otras opciones de movilidad por desarrollar:
App buses UTPL: que pretende automatizar todo el sistema de movilidad actual de buses gratuito de la UTPL; disponible para personal Utpl, estudiantes, colaboradores y público en general. La central de estos buses en el estacionamiento UTPL, con recorridos periódicos y planificados.
Por tanto, su sistema será capaz de:

Realizar el registro de un usuario.
Prestar el servicio de movilidad solicitando al usuario los datos básicos que crea indispensables, y al final emitir una calificación del servicio basada en estrellas (1-5).
Dependiendo de la opción de movilidad elegida por el usuario, el sistema debe mostrar el detalle de su factura: Datos del cliente, empresa, opción de movilidad elegida, recorrido, tarifa por Km, tiempo, etc.
Para la solución del caso de estudio, se requiere:

Modelado de la solución UML, aprovechando al máximo las ventajas de la Abstracción, Encapsulamiento, Herencia y Polimorfismo, de la POO.
Implementación del modelado UML en el lenguaje de alto nivel orientado a objetos Java. Se debe agregar la clase de prueba/ejecutor que demuestre las funcionalidades de su solución.
Visualización clara y ordenada de los resultados generados en una eventual ejecución de su solución (prueba de escritorio).
