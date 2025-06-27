# ZKP Extension

Extension for Zero Knowledge Proofs on Postchain.

## Registration

```shell
pmc subnode-image add --name zkp_extension \
  --url registry.gitlab.com/chromaway/core/zkp-extension/chromaway/zkp-extension-chromia-subnode \
  --digest ${DIGEST} \
  --image-description "Extension to Postchain for Zero Knowledge Proofs" \
  -gtx net.postchain.zkp.ZKPGTXModule
```

This will generate a proposal which need to be voted on.

[User guide for PLONK verification](doc/plonk_verification.md)
