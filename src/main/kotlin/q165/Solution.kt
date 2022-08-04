package q165

class Solution {
    //    Constraints:
    //    1 <= version1.length, version2.length <= 500
    //    version1 and version2 only contain digits and '.'.
    //    version1 and version2 are valid version numbers.
    //    All the given revisions in version1 and version2 can be stored in a 32-bit integer.
    fun compareVersion(version1: String, version2: String): Int {
        var revisions1 = toRevisions(version1)
        var revisions2 = toRevisions(version2)
        for (i in 0..revisions1.size.coerceAtLeast(revisions2.size)) {
            val revision1 = if (i < revisions1.size) revisions1.get(i) else 0
            val revision2 = if (i < revisions2.size) revisions2.get(i) else 0
            val compareResult = revision1.compareTo(revision2)
            if (compareResult != 0) return compareResult
        }
        return 0
    }

    private fun toRevisions(version: String): List<Int> {
        return version.split(".")
            .map { r -> r.replaceFirst(Regex("0*"), "") }
            .map { r -> if (r == "") 0 else r.toInt() }
    }
}