# Security Policy

## Scopo

Questo documento descrive le policy di sicurezza per la repository **devmirkoo/ExercicesJava-Unime**.  
Sebbene si tratti di una repository didattica, si applicano buone pratiche di sicurezza per proteggere l'integrità del codice e del progetto.

---

## Segnalazione di Vulnerabilità

Se individui una vulnerabilità di sicurezza in questa repository (ad esempio una dependency con CVE noto, un segreto esposto per errore, o una misconfiguration di CI):

1. **Non aprire una Issue pubblica** — questo espone la vulnerabilità prima che sia risolta.
2. Contatta direttamente il maintainer tramite:
   - GitHub: [@devmirkoo](https://github.com/devmirkoo)
   - In alternativa, usa la funzionalità **"Report a vulnerability"** disponibile nella tab **Security** della repository.
3. Il maintainer risponderà entro **7 giorni lavorativi** e provvederà a risolvere il problema il prima possibile.

---

## Gestione di Segreti e Credenziali

- **Non committare mai** password, token, chiavi API, certificati o qualsiasi credenziale nel codice sorgente.
- Se per errore viene committato un segreto:
  1. Revoca immediatamente il segreto/token nell'account o servizio interessato.
  2. Segnala il problema al maintainer come descritto sopra.
  3. Non è sufficiente rimuovere il file in un commit successivo — il segreto rimane nella history di Git.
- Questa repository ha abilitato **Secret Scanning** e **Push Protection** su GitHub.  
  Se GitHub rileva un segreto nel tuo push, il push verrà bloccato automaticamente.

---

## Aspettative sulle Pull Request

- **Nessun push diretto su `main`** è consentito, nemmeno dal maintainer.  
  Ogni modifica deve passare attraverso una Pull Request.
- Ogni PR deve:
  - Superare i **CI checks** (compilazione Java) prima del merge.
  - Ricevere almeno **1 approvazione** da @devmirkoo (Code Owner).
  - Compilare e rispettare il **PR template** (`.github/pull_request_template.md`).
- Le approvazioni precedenti vengono invalidate se arrivano nuovi commit alla PR (dismiss stale approvals).
- I commit devono essere **firmati** (signed commits) per garantirne l'autenticità.

---

## Scope di Sicurezza

Questa repository è **didattica** e non gestisce dati utente, credenziali di produzione o sistemi critici.  
Tuttavia si applicano le seguenti best practice:

| Area | Policy |
|------|--------|
| Branch `main` | Protetto da ruleset — nessun push diretto |
| Pull Request | Obbligatoria, con review e CI checks |
| Secrets | Secret Scanning + Push Protection abilitati |
| Dipendenze | Nessuna dipendenza esterna attuale; se introdotte, usare Dependabot |
| File sensibili | `.github/`, `SECURITY.md`, workflow — protetti da CODEOWNERS |

---

## Versioni Supportate

Poiché si tratta di una repository educativa in continua evoluzione, è supportato solo lo stato attuale del branch `main`.

---

## Riferimenti

- [GitHub Secret Scanning](https://docs.github.com/en/code-security/secret-scanning)
- [GitHub Push Protection](https://docs.github.com/en/code-security/secret-scanning/push-protection-for-repositories-and-organizations)
- [CODEOWNERS](https://docs.github.com/en/repositories/managing-your-repositorys-settings-and-features/customizing-your-repository/about-code-owners)
- [GitHub Rulesets](https://docs.github.com/en/repositories/configuring-branches-and-merges-in-your-repository/managing-rulesets/about-rulesets)
