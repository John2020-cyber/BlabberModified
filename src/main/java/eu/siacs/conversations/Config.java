package eu.siacs.conversations;

import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import eu.siacs.conversations.crypto.XmppDomainVerifier;
import eu.siacs.conversations.xmpp.Jid;
import eu.siacs.conversations.xmpp.chatstate.ChatState;

public final class Config {

    public static final long MILLISECONDS_IN_DAY = 24 * 60 * 60 * 1000;

    private static final int UNENCRYPTED = 1;
    private static final int OPENPGP = 2;
    private static final int OTR = 4;
    private static final int OMEMO = 8;

    private static final int ENCRYPTION_MASK = UNENCRYPTED | OPENPGP | OTR | OMEMO;

    public static boolean supportUnencrypted() {
        return (ENCRYPTION_MASK & UNENCRYPTED) != 0;
    }

    public static boolean supportOpenPgp() {
        return (ENCRYPTION_MASK & OPENPGP) != 0;
    }

    public static boolean supportOtr() {
        return (ENCRYPTION_MASK & OTR) != 0;
    }

    public static boolean supportOmemo() {
        return (ENCRYPTION_MASK & OMEMO) != 0;
    }

    public static boolean multipleEncryptionChoices() {
        return (ENCRYPTION_MASK & (ENCRYPTION_MASK - 1)) != 0;
    }

    public static String blabber() {
        //if (Locale.getDefault().getLanguage().equalsIgnoreCase("de")) {
            return "blabber.im";
        /*} else {
            return "blabber.im/en.html";
        }*/
    }

    public static final String LOGTAG = BuildConfig.LOGTAG;

    public static final Jid BUG_REPORTS = Jid.of("bugs@pix-art.de");
    public static final Uri HELP = Uri.parse("https://help.conversations.im");

    public static final String inviteUserURL = "https://" + blabber() + "/i/";
    public static final String inviteMUCURL = "https://" + blabber() + "/j/";
    public static final String inviteHostURL = blabber(); // without http(s)
    public static final String termsOfUseURL = "https://kriztan.codeberg.page/termsofuse/";
    public static final String privacyURL = "https://kriztan.codeberg.page/privacy/";
    public static final String migrationURL = Locale.getDefault().getLanguage().equalsIgnoreCase("de") ? "https://blabber.im/anleitungen/Migration%20vom%20Pix-Art%20Messenger%20zu%20blabber.im%20(Android)%20_%20blabber.im.html" : "https://blabber.im/tutorials/Migration%20from%20Pix-Art%20Messenger%20to%20blabber.im%20(Android)%20_%20blabber.im.html";

    public static final String CHANGELOG_URL = "https://codeberg.org/kriztan/blabber.im/src/branch/master/CHANGELOG.md";
    public static final String GIT_URL = "https://codeberg.org/kriztan/blabber.im/";

    public static final String XMPP_IP = null; //BuildConfig.XMPP_IP; // set to null means disable
    public static final Integer[] XMPP_Ports = null; //BuildConfig.XMPP_Ports; // set to null means disable
    public static final String DOMAIN_LOCK = BuildConfig.DOMAIN_LOCK; //only allow account creation for this domain
    public static final String MAGIC_CREATE_DOMAIN = DOMAIN.getRandomServer();

    public static final String QUICKSY_DOMAIN = "quicksy.im";
    public static final String CHANNEL_DISCOVERY = "https://search.jabber.network";
    public static final boolean DISALLOW_REGISTRATION_IN_UI = false; //hide the register checkbox
    public static final boolean SHOW_INTRO = BuildConfig.SHOW_INTRO;
    public static final boolean SHOW_MIGRATION_INFO = BuildConfig.SHOW_MIGRATION_INFO;

    public static final boolean USE_RANDOM_RESOURCE_ON_EVERY_BIND = false;

    public static final boolean ALLOW_NON_TLS_CONNECTIONS = false; //very dangerous. you should have a good reason to set this to true

    public static final boolean FORCE_ORBOT = false; // always use TOR

    public static final boolean HIDE_MESSAGE_TEXT_IN_NOTIFICATION = false;

    public static final boolean ALWAYS_NOTIFY_BY_DEFAULT = false;
    public static final boolean SUPPRESS_ERROR_NOTIFICATION = false;

    public static final boolean DISABLE_BAN = false; // disables the ability to ban users from rooms

    public static final int PING_MAX_INTERVAL = 300;
    public static final int IDLE_PING_INTERVAL = 600; //540 is minimum according to docs;
    public static final int PING_MIN_INTERVAL = 30;
    public static final int LOW_PING_TIMEOUT = 1; // used after push received
    public static final int PING_TIMEOUT = 15;
    public static final int SOCKET_TIMEOUT = 30;
    public static final int CONNECT_TIMEOUT = 60;
    public static final int POST_CONNECTIVITY_CHANGE_PING_INTERVAL = 30;
    public static final int CONNECT_DISCO_TIMEOUT = 30;
    public static final int MINI_GRACE_PERIOD = 750;

    public static final boolean XEP_0392 = true; //enables XEP-0392 v0.6.0

    public static final int FILE_SIZE = 1048576; // 1 MiB

    public static final int AVATAR_SIZE = 480;
    public static final Bitmap.CompressFormat AVATAR_FORMAT = Bitmap.CompressFormat.JPEG;
    public static final int AVATAR_CHAR_LIMIT = 9400;

    public static final Bitmap.CompressFormat IMAGE_FORMAT = Bitmap.CompressFormat.JPEG;
    public static final int IMAGE_QUALITY = 65;

    public static final int DEFAULT_ZOOM = 15; //for locations
    public final static long LOCATION_FIX_TIME_DELTA = 1000 * 10; // ms
    public final static float LOCATION_FIX_SPACE_DELTA = 10; // m
    public final static int LOCATION_FIX_SIGNIFICANT_TIME_DELTA = 1000 * 60 * 2; // ms

    public static final int MESSAGE_MERGE_WINDOW = 20;

    public static final int PAGE_SIZE = 50;
    public static final int MAX_NUM_PAGES = 3;
    public static final int MAX_SEARCH_RESULTS = 300;

    public static final int REFRESH_UI_INTERVAL = 500;

    public static final long OMEMO_AUTO_EXPIRY = 60 * MILLISECONDS_IN_DAY; // delete old OMEMO devices after 60 days of inactivity
    public static final boolean REMOVE_BROKEN_DEVICES = false;
    public static final boolean OMEMO_PADDING = false;
    public static final boolean PUT_AUTH_TAG_INTO_KEY = true;
    public static final boolean AUTOMATICALLY_COMPLETE_SESSIONS = true;
    public static final boolean TWELVE_BYTE_IV = true;

    public static final int MAX_DISPLAY_MESSAGE_CHARS = 2 * 4096; //why only 4096? --> increased
    public static final int MAX_STORAGE_MESSAGE_CHARS = 2 * 1024 * 1024; //2MB

    public static final boolean ExportLogs = true; // automatically export logs
    public static final int ExportLogs_Hour = 4; //Time - hours: valid values from 0 to 23
    public static final int ExportLogs_Minute = 0; //Time - minutes: valid values from 0 to 59

    public static final boolean USE_BOOKMARKS2 = false;

    public static final boolean PROCESS_EXTMAP_ALLOW_MIXED = false;
    public static final boolean DISABLE_PROXY_LOOKUP = false; //useful to debug ibb
    public static final boolean USE_DIRECT_JINGLE_CANDIDATES = true;
    public static final boolean DISABLE_HTTP_UPLOAD = false;
    public static final boolean EXTENDED_SM_LOGGING = false; // log stanza counts
    public static final boolean BACKGROUND_STANZA_LOGGING = false; //log all stanzas that were received while the app is in background
    public static final boolean RESET_ATTEMPT_COUNT_ON_NETWORK_CHANGE = true; //setting to true might increase power consumption

    public static final boolean ENCRYPT_ON_HTTP_UPLOADED = false;

    public static final boolean X509_VERIFICATION = false; //use x509 certificates to verify OMEMO keys

    public static final boolean ONLY_INTERNAL_STORAGE = false; //use internal storage instead of sdcard to save attachments

    public static final boolean IGNORE_ID_REWRITE_IN_MUC = true;
    public static final boolean MUC_LEAVE_BEFORE_JOIN = false;

    public static final boolean USE_LMC_VERSION_1_1 = true;

    public static final long MAM_MAX_CATCHUP = MILLISECONDS_IN_DAY * 30;
    public static final int MAM_MAX_MESSAGES = 750;

    public static final ChatState DEFAULT_CHAT_STATE = ChatState.ACTIVE;
    public static final int TYPING_TIMEOUT = 5;

    public static final int EXPIRY_INTERVAL = 30 * 60 * 1000; // 30 minutes

    public static final String UPDATE_URL = BuildConfig.UPDATE_URL;
    public static final long UPDATE_CHECK_TIMER = 24 * 60 * 60; // 24 h in seconds

    public static final String ISSUE_URL = "xmpp://support@room.pix-art.de?join";

    public static final String[] ENABLED_CIPHERS = {
            "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256",
            "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA384",
            "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA256",
            "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384",
            "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA",
            "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA",

            "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256",
            "TLS_DHE_RSA_WITH_AES_128_GCM_SHA384",
            "TLS_DHE_RSA_WITH_AES_256_GCM_SHA256",
            "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384",

            "TLS_DHE_RSA_WITH_CAMELLIA_256_SHA",

            // Fallback.
            "TLS_RSA_WITH_AES_128_GCM_SHA256",
            "TLS_RSA_WITH_AES_128_GCM_SHA384",
            "TLS_RSA_WITH_AES_256_GCM_SHA256",
            "TLS_RSA_WITH_AES_256_GCM_SHA384",
            "TLS_RSA_WITH_AES_128_CBC_SHA256",
            "TLS_RSA_WITH_AES_128_CBC_SHA384",
            "TLS_RSA_WITH_AES_256_CBC_SHA256",
            "TLS_RSA_WITH_AES_256_CBC_SHA384",
            "TLS_RSA_WITH_AES_128_CBC_SHA",
            "TLS_RSA_WITH_AES_256_CBC_SHA",
    };

    public static final String[] WEAK_CIPHER_PATTERNS = {
            "_NULL_",
            "_EXPORT_",
            "_anon_",
            "_RC4_",
            "_DES_",
            "_MD5",
    };

    public static class OMEMO_EXCEPTIONS {
        //if the own account matches one of the following domains OMEMO won’t be turned on automatically
        public static final List<String> ACCOUNT_DOMAINS = Collections.singletonList("s.ms");

        //if the contacts domain matches one of the following domains OMEMO won’t be turned on automatically
        //can be used for well known, widely used gateways
        private static final List<String> CONTACT_DOMAINS = Arrays.asList(
                "cheogram.com",
                "*.covid.monal.im"
        );

        public static boolean matchesContactDomain(final String domain) {
            return XmppDomainVerifier.matchDomain(domain, CONTACT_DOMAINS);
        }
    }

    public static class DOMAIN {
        public static final List<String> DOMAINS = Arrays.asList(
                "conversations.im",
                "jabber.cat",
                "im.koderoot.net",
                "magicbroccoli.de",
                "wiuwiu.de",
                "5222.de",
                "chat.sum7.eu",
                "xmpp.zone",
                "laborversuch.de",
                "creep.im",
                "jabber.systemausfall.org",
                "jabber.hot-chilli.net",
                "jabber.fr",
                "jabber.de",
                "elaon.de",
                "high-way.me",
                "deshalbfrei.org",
                "im.hot-chilli.net",
                "jabberpl.org",
                "chinwag.im",
                "zsim.de",
                "im.apinc.org",
                "chatme.im",
                "yax.im",
                "neko.im",
                "jabberzac.org",
                "jabber.ccc.de",
                "jwchat.org",
                "jabber.cz",
                "xabber.de",
                "jabber.ru",
                "darknet.nz",
                "404.city",
                "tigase.im",
                "member.fsf.org",
                "twattle.net",
                "jabber.calyxinstitute.org",
                "linuxlovers.at",
                "openjabber.org",
                "jabber.no",
                "jabber.otr.im",
                "chapril.org",
                "zp1.net",
                "zsim.de",
                "xmpp.social"
        );

        public static String getRandomServer() {
            final String domain = DOMAINS.get(new Random().nextInt(DOMAINS.size()));
            Log.d(LOGTAG, "Magic Create domain: " + domain);
            return domain;
        }
    }

    private Config() {
    }
}
