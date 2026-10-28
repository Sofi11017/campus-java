public class S05Lab02MedidasRectangulo {
    public static void main(String[] args) {
        // TODO 6: Crear primeraFigura de 5 por 3 y segundaFigura de 4 por 4.
        S05Rectangulo primeraFigura = new S05Rectangulo(5, 3);
        S05Rectangulo segundaFigura = new S05Rectangulo(4, 4);

        // TODO 7: Mostrar area, perimetro y esCuadrado de cada figura.
        System.out.println("Figura 1 - Area: " + primeraFigura.calcularArea());
        System.out.println("Figura 1 - Perimetro: " + primeraFigura.calcularPerimetro());
        System.out.println("Figura 1 - Cuadrado: " + primeraFigura.esCuadrado());
        System.out.println("Figura 2 - Area: " + segundaFigura.calcularArea());
        System.out.println("Figura 2 - Perimetro: " + segundaFigura.calcularPerimetro());
        System.out.println("Figura 2 - Cuadrado: " + segundaFigura.esCuadrado());
    }
}