// Kassie Whitney
public class BakingCalculator {
    public static void main(String[] args) {

    }

    public static int bagsOfFlour(int cookieCount, int loafCount) {

        double cupsFlourCookies = 2.25;
        double cupsFlourLoaf = 1.5;
        double batchOfCookies = 48.0;
        double cupsOfFlourPerLbs = 3+1.0/3.0;
        double lbsOfFlourPerBag = 5.0;
        double bagsOfFlourNeeded = (((cupsFlourCookies / batchOfCookies * cookieCount) +
                (cupsFlourLoaf * loafCount)) / cupsOfFlourPerLbs) / lbsOfFlourPerBag;

        return  (int) Math.ceil(bagsOfFlourNeeded);
    }
    public static int containersOfSalt(int cookieCount, int loafCount) {

        double numOfTspCookies = 1.0;
        double numOfTspLoaf = 1.0/8.0;
        double batchOfCookies = 48.0;

        double ozOfSaltPerContainer = 26.0;
        double numberOfTspPerOz = 6.0;

        double numOfContainersNeeded = (((numOfTspCookies / batchOfCookies * cookieCount) +
                (numOfTspLoaf * loafCount)) / numberOfTspPerOz) / ozOfSaltPerContainer;


        return (int) Math.ceil(numOfContainersNeeded);
    }

    public static int boxesOfBakingSoda(int cookieCount, int loafCount) {

        double numOfTspCookies = 1.0;
        double numTspLoaf = 1.0;
        double batchOfCookies = 48.0;

        double numOfTspPerOz = 6.0;
        double ozOfBakingSodaPerBox = 16.0;

        double numOfBoxesNeeded = (((numOfTspCookies / batchOfCookies * cookieCount) +
                (numTspLoaf * loafCount)) / numOfTspPerOz) / ozOfBakingSodaPerBox;

        return (int) Math.ceil(numOfBoxesNeeded);
    }

    public static int bottlesOfVanilla(int cookieCount, int loafCount) {

        double tspVanillaCookies = 1.0;
        double tspVanillaLoaf = 1.0;
        double batchOfCookies = 48.0;

        double tspPerOz = 6.0;
        double ozPerBottle = 1.0;

        double numOfBottlesNeeded = (((tspVanillaCookies / batchOfCookies * cookieCount) +
                (tspVanillaLoaf * loafCount)) / tspPerOz) / ozPerBottle;

        return (int) Math.ceil(numOfBottlesNeeded);
    }
    public static int cartonsOfEggs(int cookieCount, int loafCount) {

        double numEggsCookies = 2.0;
        double numEggsLoaf = 1.0;
        double batchOfCookies = 48.0;

        double numEggsPerContainer = 12;

        double numOfContainers = ((numEggsCookies / batchOfCookies * cookieCount) +
                (numEggsLoaf * loafCount)) / numEggsPerContainer;

        return (int) Math.ceil(numOfContainers);
    }

    public static int bagsOfSugar(int cookieCount, int loafCount) {

        double numCupsCookies = 1 + 1.0/2.0;
        double numCupsLoaf = 3.0/4.0;
        double batchOfCookies = 48.0;

        double cupsPerBag = 2.0;

        double numOfBagsNeeded = (((numCupsCookies / batchOfCookies * cookieCount) +
                (numCupsLoaf * loafCount)) / cupsPerBag);

        return (int) Math.ceil(numOfBagsNeeded);
    }

    public static int packagesOfButter(int cookieCount, int loafCount) {

        double numCupsCookies = 1.0;
        double numCupsLoaf = 1.0/3.0;
        double batchOfCookies = 48.0;

        double cupsPerStick = 1.0/2.0;
        double numSticksPerPackage = 4.0;

        double numOfPackagesNeeded = (((numCupsCookies / batchOfCookies * cookieCount) +
                (numCupsLoaf * loafCount)) / cupsPerStick ) / numSticksPerPackage;


        return (int) Math.ceil(numOfPackagesNeeded);
    }
    public static int bananas(int cookieCount, int loafCount) {

        double numOfBananasCookies = 0;
        double numOfBananasLoaf = 3.0;
        double batchOfCookies = 48.0;

        return (int) ((numOfBananasLoaf * loafCount) +
                (numOfBananasCookies / batchOfCookies * cookieCount));
    }
    public static int bagsOfChocolateChips(int cookieCount, int loafCount) {

        double numCupsCookies = (2.5);
        double numCupsLoaf = 0.0;
        double batchOfCookies = 48.0;

        double cupsPerOz = 1.0/6.0;
        double ozPerBag = 12.0;

        double numOfBagsNeeded = (((numCupsCookies / batchOfCookies * cookieCount) +
                (numCupsLoaf * loafCount))/ cupsPerOz / ozPerBag);


        return (int) Math.ceil(numOfBagsNeeded);
    }
    public static double totalCost(int cookieCount, int loafCount) {
        double bagsOfFlourCost = bagsOfFlour(cookieCount,loafCount) * 1.79;
        double containersOfSaltCost = containersOfSalt(cookieCount, loafCount) * 1.09;
        double boxesOfBakingSodaCost = boxesOfBakingSoda(cookieCount, loafCount) * 1.09;
        double bottlesOfVanillaCost = bottlesOfVanilla(cookieCount, loafCount) * 3.99;
        double cartonsOfEggsCost = cartonsOfEggs(cookieCount, loafCount) * 2.19;
        double bagsOfSugarCost = bagsOfSugar(cookieCount, loafCount) * 1.99;
        double packagesOfButterCost = packagesOfButter(cookieCount, loafCount) * 4.49;
        double bananasCost = bananas(cookieCount, loafCount) * 0.32;
        double bagsOfChocolateChipsCost = bagsOfChocolateChips(cookieCount, loafCount) * 3.29;

        return bagsOfFlourCost + containersOfSaltCost + boxesOfBakingSodaCost + bottlesOfVanillaCost + cartonsOfEggsCost
                + bagsOfSugarCost + packagesOfButterCost + bananasCost + bagsOfChocolateChipsCost;
    }
}
