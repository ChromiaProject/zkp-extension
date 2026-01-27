package net.postchain.zkp.plonk

import net.postchain.gtv.mapper.Name
import net.postchain.zkp.curve.BLS12381
import net.postchain.zkp.curve.BN128
import net.postchain.zkp.curve.G1Point
import net.postchain.zkp.curve.G2Point
import java.math.BigInteger

data class PlonkVerificationKey(
        @param:Name("curve")
        val curveName: CurveName,
        @param:Name("nPublic")
        val nPublicLong: Long,
        @param:Name("power")
        val powerLong: Long,
        @param:Name("Qm")
        val Qm: G1Point,
        @param:Name("Ql")
        val Ql: G1Point,
        @param:Name("Qr")
        val Qr: G1Point,
        @param:Name("Qo")
        val Qo: G1Point,
        @param:Name("Qc")
        val Qc: G1Point,
        @param:Name("S1")
        val S1: G1Point,
        @param:Name("S2")
        val S2: G1Point,
        @param:Name("S3")
        val S3: G1Point,
        @param:Name("k1")
        val k1: BigInteger,
        @param:Name("k2")
        val k2: BigInteger,
        @param:Name("X_2")
        val X2: G2Point
) {
    enum class CurveName {
        bls12381,
        bn128;

        fun getCurve() = when (this) {
            bls12381 -> BLS12381
            bn128 -> BN128
        }
    }

    // Since GTV Object mapper can't parse Int (and this way we can avoid toInt() everywhere else)
    val nPublic = nPublicLong.toInt()
    val power = powerLong.toInt()

    val n: BigInteger = BigInteger.valueOf(2).pow(power)

    val nLagrange = maxOf(nPublic, 1)

    val curve = curveName.getCurve()
}
